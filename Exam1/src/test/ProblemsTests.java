package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import problems.ListProblems;

public class ProblemsTests {
	
	@Test
	public void testSort() {
		assertArrayEquals(new Integer[] {1, 2, 3, 4}, ListProblems.sort(Arrays.asList(4, 3, 1, 2)).toArray());
	}
	
	@Test
	public void tesReverset() {
		assertArrayEquals(new Integer[] {4, 3, 2, 1}, ListProblems.reverse(Arrays.asList(1, 2, 3, 4)).toArray());
	}

	@Test
	public void tesMonotonous() {
		assertTrue(ListProblems.isMonotonous(Arrays.asList(1, 2, 3, 4)));
		assertTrue(ListProblems.isMonotonous(Arrays.asList(6,5,4,3,2,1,1,1)));
		assertFalse(ListProblems.isMonotonous(Arrays.asList(1,2,1,4,5,4)));
		assertTrue(ListProblems.isMonotonous(Arrays.asList(1)));
	}
	
}
