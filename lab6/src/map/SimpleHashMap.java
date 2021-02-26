package map;

import java.util.ArrayList;

public class SimpleHashMap<K,V> implements Map<K, V> {
	Entry<K,V>[] table;
	int size;
	int cap;
	double loadfactor;

	private static class Entry<K,V> implements Map.Entry<K, V> {
		private K key;
		private V val;
		private Entry<K,V> next;
		
		public Entry(K key, V val) {
			this.key=key;
			this.val=val;
			this.next=null;
			
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return val;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			V hold = this.val;
			this.val=value;
			return hold;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.key+" = "+this.val;
		}


	}
	
	//D3
	public SimpleHashMap() {
		this.size=0;
		this.cap=16;
		this.loadfactor=0.75;
		this.table=(Entry<K,V>[]) new Entry[cap]; //Initial capacity 16
	}
	
	public SimpleHashMap(int capacity) {
		this.size=0;
		this.cap=capacity;
		this.loadfactor=0.75;
		this.table=(Entry<K,V>[]) new Entry[cap];	
	}
	
	public String show() {
		String s= "";
		for (int i=0 ; i<table.length; i++) {
			s+=i+"      ";
			if (table[i]!=null) {
				Entry<K,V> tmp= table[i];
				while (tmp!=null) {
					s+=tmp.toString() + "   ";
					tmp=tmp.next;
				}
				
			}
			s+="\n";
		}
		return s;
	}
	//D6
	private int index(K key) {
		return Math.abs(key.hashCode()%cap);
	}
	
	private Entry<K,V> find(int index, K key) {
		Entry<K,V> tmp = table[index];
		//System.out.println(
		//		"index="+index+"\n" + "Key= "+ key+"\n"+ "Table="+table[index]
		//		);
		if (tmp!=null && tmp.getKey().equals(key)) {
			return tmp;
		}
		while (tmp!=null) {
			if (tmp.getKey().equals(key)) {
				return tmp;
			} else {
				tmp=tmp.next;
			}
		}
		//System.out.println("Not found");
		return null;
		
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		if (find(index((K) key), ((K) key))!=null) {
			return find(index((K) key), ((K) key)).getValue();
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size==0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public V put(K key, V val) {
		// TODO Auto-generated method stub
		Entry<K,V> temp = find(index(key), key);
		if (temp!=null) { //if key already exists
			V prev = temp.getValue();
			temp.setValue(val);
			return prev;
		} else {
			this.size+=1;
			temp = table[index(key)];
			if (temp==null) {
				table[index(key)]= new Entry<K,V>(key, val);
			} else if (temp.next==null) {
				table[index(key)].next = new Entry<K,V>(key, val);
			} else {
				while (temp.next!=null) {
					temp=temp.next;
				}
				temp.next = new Entry<K,V>(key, val);
			}
			if (((double) size)/((double) cap)>=loadfactor) {
				this.rehash();
			}
			return null;
		}
	}
	
		
	private void rehash() {
		//list of all objects in table
		SimpleHashMap<K,V> tab2 = new SimpleHashMap(2*cap);
		for (int i=0; i<table.length; i++) {
			if (table[i]!=null) {
				Entry<K,V> tmp = table[i];
				while (tmp!=null) {
					tab2.put(tmp.key, tmp.val);
					tmp=tmp.next;
				}
			}
		}
		this.cap = 2*cap;
		this.table = tab2.table;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		if (this.table==null) {
			return null;
		}
		int indx = index((K) key);
		Entry<K,V> temp = table[indx];
		if (temp==null) {
			return null;
		} else if (temp.key.equals(key)) { //1st case
			V val = temp.val;
			table[indx]=table[indx].next;
			this.size-=1;
			return val;
		}
		Entry<K,V> nxt = table[indx].next;
		while (nxt!=null) {
			if (nxt.key.equals(key)) {
				V val = nxt.val;
				temp.next = nxt.next;
				this.size-=1;
				return val;
			} else {
				temp = temp.next;
				nxt = nxt.next;
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> m16 = new SimpleHashMap(); 
		for (int i=0; i<12; i++) {
			m16.put(i*i, i);
			//m16.put(-i, -i);
		}
		//m16.remove(5);
		System.out.println(m16.show());
		System.out.println(m16.remove(8));
	}

}
