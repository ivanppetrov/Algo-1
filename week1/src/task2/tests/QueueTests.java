package task2.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task2.solution.Queue;
import task2.solution.QueueImpl;

public class QueueTests {
	public static final int SIZE = 100000;
	static Queue<Integer> queue, queueList;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new QueueImpl<Integer>();
		queueList = new QueueImpl<Integer>();
	}

	@Test
	public void test() {
		//QueueImpl test
		assertEquals(0, queue.size());
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		assertEquals("[1 2 3 4 ]", queue.toString());
		assertEquals(new Integer(1), queue.peek());
		queue.pop();
		assertEquals("[2 3 4 ]", queue.toString());
		assertEquals(3, queue.size());
		
		//QueueList tests
		assertEquals(0, queueList.size());
		queueList.push(1);
		queueList.push(2);
		queueList.push(3);
		queueList.push(4);
		assertEquals("[1 2 3 4 ]", queueList.toString());
		assertEquals(new Integer(1), queueList.peek());
		queueList.pop();
		assertEquals("[2 3 4 ]", queueList.toString());
		assertEquals(new Integer(2), queueList.peek());
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			queue.push(i);
		}
		
		for (int i = 0; i < SIZE; i++) {
			queue.pop();
		}
		
		System.out.println(System.currentTimeMillis() - start);
		
		
		long startList = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			queueList.push(i);
		}
		
		for (int i = 0; i < SIZE; i++) {
			queueList.pop();
		}
		System.out.println(System.currentTimeMillis() - startList);
	}

}
