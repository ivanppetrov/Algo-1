package task5.solution;

public class InsertionSort {
	public static void sort(int[] array) {
		int tempElem = 0;
		
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				tempElem = array[j - 1];
				array[j - 1] = array[j];
				array[j] = tempElem;
				j--;
			}
		}
	}
}
