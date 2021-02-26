package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this.size = 0;
		this.root = null;
		this.comparator = (a,b) -> ((Comparable<E>) a).compareTo(b);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.root = null;
	}

	public BinarySearchTree(Object object) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			this.size+=1;
			return true;
		} else {
			return recAdd(x, root);
		}
	}
	private boolean recAdd(E x, BinaryNode<E> node) {
		if (x.equals(node.element)) {
			return false;
		} else if (comparator.compare(x, node.element)<0) {
			if (node.left!=null) {
				return recAdd(x,node.left);
			} else {
				node.left = new BinaryNode<E>(x);
				this.size+=1;
				return true;
			}
			
		} else {
			if (node.right!=null) {
				return recAdd(x,node.right);
			} else {
				node.right = new BinaryNode<E>(x);
				this.size+=1;
				return true;
			}
		} 
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return recHeight(root);		
	}
	
	private int recHeight(BinaryNode<E> node) {
		if (node==null) {
			return 0;
		} else {
			return 1 + Math.max(recHeight(node.left), recHeight(node.right));
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		this.size=0;
		this.root=null;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if (root==null) {
			System.out.println("Empty");
		} else {
			recPrintTree(root);
		}
	}
	private void recPrintTree(BinaryNode<E> node) {
		if (node!=null) {
			recPrintTree(node.left);
			System.out.println(node.element);
			recPrintTree(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		if (root==null) {
			//Do nothing
		} else {
			ArrayList<E> slist = new ArrayList<E>();
			this.toArray(root, slist);
			this.root = buildTree(slist,0,slist.size()-1);
		}
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> node, ArrayList<E> sorted) {
		if (node!=null) {
			toArray(node.left, sorted);
			sorted.add(node.element);
			toArray(node.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first>last) {
			return null; //can't "fold"
		}
		if (first==last) {
			return new BinaryNode<E>(sorted.get(first));  // if width = 1
		}
		
		int mid = (first+last)/2;
		BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid));
		node.left = buildTree(sorted, first, mid-1);
		node.right = buildTree(sorted, mid+1, last);
		return node;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bs = new BinarySearchTree();
		bs.add(5);
		bs.add(2);
		bs.add(7);
		bs.add(9);
		bs.add(6);
		bs.add(11);
		bs.add(20);
		bs.add(50);
		bs.add(51);
		bs.add(49);
		bs.add(500);
		bs.add(2);
		bs.add(1);
		bs.add(25);
		
		bs.printTree();
		BSTVisualizer graphicskew = new BSTVisualizer("BinaryTree", 300, 300);
		graphicskew.drawTree(bs);
		bs.rebuild();
		BSTVisualizer graphicrebuilt = new BSTVisualizer("BinaryTree", 300, 300);
		graphicrebuilt.drawTree(bs);	
		
		//Comparator<String> comp = (String a, String b) -> a.length() - b.length();
		BinarySearchTree bs2 = new BinarySearchTree((a,b)->((String) a).length() -((String) b).length());
		bs2.add("l".repeat(5));
		bs2.add("l".repeat(2));
		bs2.add("l".repeat(7));
		bs2.add("l".repeat(9));
		bs2.add("l".repeat(6));
		bs2.add("l".repeat(11));
		bs2.add("l".repeat(20));
		bs2.add("l".repeat(50));
		bs2.add("l".repeat(51));
		bs2.add("l".repeat(49));
		bs2.add("l".repeat(2));
		bs2.add("l".repeat(1));
		bs2.add("l".repeat(25));
		
		bs2.printTree();
		BSTVisualizer graphicskew2 = new BSTVisualizer("BinaryTree", 300, 300);
		graphicskew2.drawTree(bs2);
		bs2.rebuild();
		BSTVisualizer graphicrebuilt2 = new BSTVisualizer("BinaryTree", 300, 300);
		graphicrebuilt2.drawTree(bs2);
	}
}
