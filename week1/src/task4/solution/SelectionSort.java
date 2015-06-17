package task4.solution;

public class SelectionSort {
	public static void sort(int[] array) {
		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
}
