package task1.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task1.solution.Vector;
import task1.solution.VectorImpl;

public class VectorTests {
	static Vector<Integer> vector;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		vector = new VectorImpl<Integer>();
	}

	@Test
	public void test() {
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		assertEquals("[1 2 3 4 ]", vector.toString());
		assertEquals(new Integer(2), vector.get(1));
		assertEquals(4, vector.size());
		assertEquals(new Integer(4), vector.pop());
		assertEquals(3, vector.size());
		assertEquals(new Integer(2), vector.remove(1));
		assertEquals("[1 3 ]", vector.toString());
		assertTrue(vector.insert(1, 10));
		assertEquals("[1 10 3 ]", vector.toString());
	}

}
