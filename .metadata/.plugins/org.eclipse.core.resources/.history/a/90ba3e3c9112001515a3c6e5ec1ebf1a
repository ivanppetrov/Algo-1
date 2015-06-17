package task4.solution;

public class MergeSort {
	private static int[] helper;
	
	public static void sort(int[] array) {
		helper = new int[array.length];
		split(array, 0, array.length - 1);
	}
	
	private static void split(int[] array, int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			split(array, low, middle);
			split(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}
	
	private static void merge(int[] array, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
	    }
		
		//index in the original array
		int aIndex = low;
		int mid = middle + 1;
		
		while(low <= middle && mid <= high) {
			if (helper[low] <= helper[mid]) {
				array[aIndex] = helper[low++];
			} else {
				array[aIndex] = helper[mid++];
			}
			aIndex++;
		}
		
		while (low <= middle) {
			array[aIndex++] = helper[low++];
		}
	}
}