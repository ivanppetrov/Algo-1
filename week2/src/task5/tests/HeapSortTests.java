package task5.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task5.solutions.HeapSort;

public class HeapSortTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		int[] array = new int[]{4, 13, 52, 7, 18, 3, 1, 6};
		HeapSort.heapSort(array);
		
		assertArrayEquals(new int[]{1, 3, 4, 6, 7, 13, 18, 52}, array);
	}

}
