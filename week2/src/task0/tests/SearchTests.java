package task0.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import task0.solutions.BinaryHeap;
import task0.solutions.BinarySearch;

public class SearchTests {
	private static final int NUMBER_OF_ARRAYS = 10000;
	private static final int ARRAY_BOUND = 10000;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void test() {
		Random random = new Random();
		for (int i = 0; i < NUMBER_OF_ARRAYS; i++) {
			int[] array = TestGenerator.generateTestArray(random.nextInt(ARRAY_BOUND) + 2);
			int searchedElement = array[random.nextInt(array.length - 1)];
			
			assertEquals(TestGenerator.isContain(array, searchedElement), BinarySearch.binarySearch(array, searchedElement, 0, array.length - 1));
		}
		
		BinaryHeap heap = new BinaryHeap();
		
		heap.insert(10);
		heap.insert(7);
		heap.insert(8);
		heap.insert(5);
		heap.insert(4);
		heap.insert(1);
		heap.insert(2);
		heap.insert(1);
		
		
		System.out.println(heap.toString());
		
		heap.removeMax();
		
		System.out.println(heap.toString());
	}

}
