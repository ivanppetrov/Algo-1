package task5.solutions;

import task0.solutions.BinaryHeap;

public class HeapSort {
	public static void heapSort(int[] array) {
		BinaryHeap heap = new BinaryHeap();
		
		for (int i = 0; i < array.length; i++) {
			heap.insertMax(array[i]);
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = heap.getTop();
			heap.removeMax();
		}
	}
}