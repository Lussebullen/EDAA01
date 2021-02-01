package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;
	
	@BeforeEach
	void setUp() {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown(){
		q1 = null;
		q2 = null;
	}

	@Test
	void testTomTom() {
		q1.append(q2);
		assertTrue(q1.size() == 0);
		assertTrue(q1.peek()==null);
	}
	
	@Test
	void testNottomTom() {
		q1.offer(1);
		q1.offer(4);
		q1.offer(10);
		q1.append(q2);
		assertTrue(q1.size() == 3);
		assertTrue(q2.size() == 0);
		assertTrue(q1.poll()==1);
		assertTrue(q1.poll()==4);
		assertTrue(q1.poll()==10);
		assertTrue(q1.poll()==null);
	}
	
	@Test
	void testTomNottom() {
		q2.offer(1);
		q2.offer(4);
		q2.offer(10);
		q1.append(q2);
		assertTrue(q1.size() == 3);
		assertTrue(q2.size() == 0);
		assertTrue(q1.poll()==1);
		assertTrue(q1.poll()==4);
		assertTrue(q1.poll()==10);
		assertTrue(q1.poll()==null);
	}
	
	@Test
	void testFulFul() {
		for (int i=0; i<9; i++) {
			q1.offer(i*100);
		}
		
		q2.offer(1);
		q2.offer(4);
		q2.offer(10);
		q1.append(q2);
		assertTrue(q1.size() == 12);
		assertTrue(q2.size() == 0);
		
		for (int i=0; i<9; i++) {
			assertTrue(q1.poll()==i*100);
		}
		assertTrue(q1.poll()==1);
		assertTrue(q1.poll()==4);
		assertTrue(q1.poll()==10);
		assertTrue(q1.poll()==null);
	}
	
	@Test
	void testError() {
			
		q2.offer(1);
		q2.offer(4);
		q2.offer(10);
		
		q1 = q2;
		
		assertThrows(IllegalArgumentException.class, () -> q1.append(q2));
	}


}
