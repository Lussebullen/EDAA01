package bst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTtest {
	private BinarySearchTree<Integer> bs1;
	private BinarySearchTree<String> bs2;
	private Comparator<String> comp;
	
	@BeforeEach
	void setUp() throws Exception {
		bs1 = new BinarySearchTree();
		//comp = (String a, String b) -> a.length() - b.length(); //why cant I just put this in as parameter directly???
		bs2 = new BinarySearchTree((a, b) -> ((String) a).length() - ((String) b).length());
	}

	@AfterEach
	void tearDown() throws Exception {
		bs1 = null;
		comp = null;
		bs2 = null;
	}
	
	
	@Test
	void testAdd() {
		assertTrue(bs1.add(1), "Add doesnt return true");
		assertFalse(bs1.add(1), "Add doesnt return false");
		assertTrue(bs2.add("k"), "Comp add doesnt return true");
		assertFalse(bs2.add("k"), "Comp add doesnt return false");
	}
	
	@Test
	void testSizeClear() {
		assertTrue(bs1.size()==0,"Newly instantiated tree not correct size");
		assertTrue(bs2.size()==0,"Newly instantiated comp tree not correct size");
		for (int i = 0; i < 10; i++) {
			bs1.add(i);
			assertTrue(bs1.size()==i+1,"Height increments don't work");
			bs2.add("k".repeat(i+1));
			assertTrue(bs2.size()==i+1,"Height increments comp don't work");
		}
		bs1.clear();
		bs2.clear();
		assertTrue(bs1.size()==0,"Cleared tree not correct size");
		assertTrue(bs2.size()==0,"Cleared comp tree not correct size");
	}
	
	@Test
	void testHeight() {
		assertTrue(bs1.height()==0);
		assertTrue(bs1.add(3));
		assertTrue(bs1.add(20));
		assertTrue(bs1.add(34));
		assertTrue(bs1.add(15));
		assertTrue(bs1.height() == 3);
		
		assertTrue(bs2.height()==0);
		assertTrue(bs2.add("k"));
		assertTrue(bs2.add("kkk"));
		assertTrue(bs2.add("kkkk"));
		assertTrue(bs2.add("kk"));
		assertTrue(bs2.height() == 3);
	}

	
	

}
