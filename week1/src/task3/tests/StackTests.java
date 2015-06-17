package task3.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task3.solution.Stack;
import task3.solution.StackImpl;

public class StackTests {
	static Stack<Integer> stack;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stack = new StackImpl<Integer>();
	}

	@Test
	public void test() {
		assertEquals(0, stack.size());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals("[1 2 3 4 ]", stack.toString());
		assertEquals(new Integer(4), stack.peek());
		stack.pop();
		assertEquals("[1 2 3 ]", stack.toString());
	}

}
