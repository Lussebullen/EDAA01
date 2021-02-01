package queue_singlelinkedlist;

import java.util.Iterator;

public class Main {
public static void main(String[] args) {
	FifoQueue<Integer> ko = new FifoQueue<Integer>();
	ko.offer(2);
	ko.offer(4);
	ko.offer(7);
	Iterator<Integer> itr = ko.iterator();
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());

	

}
}