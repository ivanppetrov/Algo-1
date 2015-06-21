package task6.solutions;

import java.util.ArrayList;
import java.util.List;

import task0.solutions.BinaryHeap;

public class KLists {
	// Merge K sorted lists.
	public List<Integer> merge(List<Integer[]> lists) {
		List<Integer> result = new ArrayList<Integer>();
		BinaryHeap heap = new BinaryHeap();
		
		for (Integer[] array : lists) {
			heap.insertMin(array[0]);
		}
		
		result.add(heap.getTop());
		heap.removeMin();
		
		return null;
		
	}
}
