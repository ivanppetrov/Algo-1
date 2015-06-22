package task7.solutions;

import java.util.List;

import task0.solutions.BinaryHeap;

public class KMin {
	public static int kthMinimum(List<Integer> list, int k) {
		//insert always k  elements in heap
		BinaryHeap heap = new BinaryHeap();
		
		for (int i = 0; i < k; i++) {
			heap.insertMax(list.get(i));
		}
		
		for (int i = k ; i < list.size(); i++) {
			int current = list.get(i);
			if (heap.getTop() > current) {
				heap.removeMax();
				heap.insertMax(current);
			}
		}
		
		return heap.getTop();
	}
}
