package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import implementation.BoundedQueue;
import implementation.Problems4;

import org.junit.Test;

public class Problems4Tests {
	private final Problems4 problems4 = new Problems4();
	
	@Test
	public void testCheckStack() {
		assertTrue(problems4.checkBrackets("()()()"));
		assertTrue(problems4.checkBrackets("(())()()"));
		assertFalse(problems4.checkBrackets("())("));
		
		Collection<Object> collection = new ArrayList<Object>();
		collection.add("");
		collection.add(1);
		collection.add("2");
		assertEquals(0, problems4.addRemoveElement(collection, null));
		assertEquals(1, problems4.addRemoveElement(collection, 1));
		assertEquals(2, problems4.addRemoveElement(collection, 2));
		
		BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
		assertTrue(boundedQueue.offer(1));
		assertTrue(boundedQueue.offer(2));
		assertTrue(boundedQueue.offer(3));
		assertFalse(boundedQueue.offer(4));
		assertFalse(boundedQueue.offer(5));
		System.out.println(boundedQueue.toString());
	}
}
