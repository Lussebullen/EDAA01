package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {				//Under what condition would it fail? Wrong type or?
			QueueNode<E> p = new QueueNode<E>(e);
			if (last==null) {
				last = p;
				last.next = p;
				size++;
				return true;
			} else {
				QueueNode<E> first = last.next;
				p.next = first;
				last.next = p;
				last=p;
				size++;
				return true;	
			}
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (last==null) {
			return null;
		} else {
			return last.next.element;
		}
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (size==0) {
			return null;
		} else if (size==1) {
			E first = last.element;
			last.next = last = null;
			size--;
			return first;
		} else {
			E first = last.next.element;
			last.next=last.next.next;
			size--;
			return first;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		
		private QueueIterator() {
			this.pos = null;
		}
		
		public boolean hasNext() {
			if (size==0) {
				return false;
			} else {
				if (pos==last) {
					return false;
				} else {
					return true;
				}
			}
		}
		
		public E next() {
			if (pos==null && last==null) {
				throw new NoSuchElementException();
			} else if (pos==null) {
				this.pos = last.next;
				return pos.element;
			} else if (pos!=last) {
				this.pos = pos.next;
				return pos.element;
			} else {
				throw new NoSuchElementException();
			}
		}
	}
	/** Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical*/
	public void append(FifoQueue<E> q) {
		if (last==null && q.last==null) {
		} else if (last==q.last) {
			throw new IllegalArgumentException();
		} else if (q.size == 0) {
		} else if (size == 0) {
			this.last = q.last;
			//this.last.next = q.last.next;
			size=q.size;
			q.last=null;
			q.size=0;
		} else {
			QueueNode<E> qfirst = q.last.next;
			q.last.next = last.next;
			last.next = qfirst;
			this.last = q.last;
			q.last = null;
			size+=q.size;
			q.size = 0;
		}
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
