package task7.solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import task0.solutions.BinaryHeap;

public class KMin {
	public static int kthMinimum(List<Integer> list, int k) {
		BinaryHeap heap = new BinaryHeap();
		Set<Integer> set = new HashSet<Integer>();
		
		for (Integer elem : list) {
			if (set.add(elem)) {
				heap.insertMin(elem);
			}
		}
		
		for (int i = 0; i < k - 1; i++) {
			heap.removeMin();
		}
		
		
		return heap.getTop();
	}
}
