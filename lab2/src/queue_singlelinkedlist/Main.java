package queue_singlelinkedlist;

import java.util.Iterator;

public class Main {
public static void main(String[] args) {
	FifoQueue<Integer> ko = new FifoQueue<Integer>();
	ko.offer(2);
	ko.offer(4);
	ko.offer(7);
	
	FifoQueue<Integer> ged = new FifoQueue<Integer>();
	ged.offer(420);
	ged.offer(69);
	
	ko.append(ged);
	
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	System.out.println(ko.poll());
	
	FifoQueue<Integer> ok = ko;
	ko.append(ok);
}
}