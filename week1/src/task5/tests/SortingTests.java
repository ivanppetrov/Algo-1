package task5.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import task5.solution.CountingSort;
import task5.solution.InsertionSort;
import task5.solution.MergeSort;
import task5.solution.QuickSort;
import task5.solution.SelectionSort;

public class SortingTests {
	public static final int SIZE = 100000;
	public static final int MAX_NUMBER = 10;
	public static int[] selectionArray = new int[SIZE];
	public static int[] insertionArray = new int[SIZE];
	public static int[] mergeArray = new int[SIZE];
	public static int[] quickArray = new int[SIZE];
	public static int[] countArray = new int[SIZE];
	public static Random random;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		random = new Random();
		for (int i = 0; i < SIZE; i++) {
			int number = random.nextInt(SIZE);
			selectionArray[i] = number;
			insertionArray[i] = number;
			mergeArray[i] = number;
			quickArray[i] = number;
		}
		
		//initializing the array for counting sort  
		for (int i = 0; i < SIZE; i++) {
			int number = random.nextInt(MAX_NUMBER + 1);
			countArray[i] = number;
		}
	}

	@Test
	public void test() {
		//Selection sort test
		long startSelection = System.currentTimeMillis();
		SelectionSort.sort(selectionArray);
		System.out.printf("\nSelertion sort: %d", System.currentTimeMillis() - startSelection);
		assertTrue(isSorted(selectionArray));
		
		//Insertion sort test
		long startInsertion = System.currentTimeMillis();
		InsertionSort.sort(insertionArray);
		System.out.printf("\nInsertion sort: %d", System.currentTimeMillis() - startInsertion);
		assertTrue(isSorted(insertionArray));
		
		//Merge sort test
		long startMerge = System.currentTimeMillis();
		MergeSort.sort(mergeArray);
		System.out.printf("\nMerge sort: %d", System.currentTimeMillis() - startMerge);
		assertTrue(isSorted(mergeArray));
		
		//Merge sort test
		long startQuick = System.currentTimeMillis();
		QuickSort.sort(quickArray);
		System.out.printf("\nQuick sort: %d", System.currentTimeMillis() - startQuick);
		assertTrue(isSorted(quickArray));
		
		//Counting sort test
		long startCount = System.currentTimeMillis();
		int[] countResult = CountingSort.sort(countArray, MAX_NUMBER);
		System.out.printf("\nCounting sort: %d", System.currentTimeMillis() - startCount);
		assertTrue(isSorted(countResult));
	}
	
	
	private boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
}
