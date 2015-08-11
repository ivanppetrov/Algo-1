package task0.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import task0.solutions.BinaryHeap;

public class BinaryHeapTests {
	static int size;
	static ArrayList<Integer> testArray;
	static int[] workingArray;
	static BinaryHeap heap;
	static Random rd;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		size = 200;
		rd = new Random();
		testArray = new ArrayList<Integer>();
		workingArray = new int[size];
		heap = new BinaryHeap();
		
		for (int i = 0; i < size; i++) {
			int value = rd.nextInt(2 * size);
			testArray.add(value);
			heap.insertMin(value);
		}
		
		Collections.sort(testArray);
		
	}

	@Test
	public void test() {
		
		for (int i = 0; i < testArray.size(); i++) {
			int removed = heap.getTop();
			assertEquals((int)testArray.remove(0), removed);
			heap.removeMin();
			int newValue = 0;
			if (i % 7 == 0) {
				newValue = rd.nextInt(2 * size);
				testArray.add(newValue);
				Collections.sort(testArray);
				heap.insertMin(newValue);
			}
		}

	}

}
