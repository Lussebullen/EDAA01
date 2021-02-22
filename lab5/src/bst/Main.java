package bst;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bs = new BinarySearchTree();
		//System.out.println("size "+bs.size()+" element "+bs.root);
		bs.add(5);
		//System.out.println("size "+bs.size()+" element "+bs.root.element);
		bs.add(2);
		//System.out.println("size "+bs.size()+" element "+bs.root.left.element);
		bs.add(7);
		bs.add(9);
		bs.printTree();
	}

}
