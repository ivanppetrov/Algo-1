package task5.solution;

public class QuickSort {
	public static void sort(int[] array){
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int lowest, int highest) {
		if (lowest < highest) {
			int pivot = partition(array, lowest, highest);
			quickSort(array, lowest, pivot - 1);
			quickSort(array, pivot + 1, highest);
		}
	}
	
	private static int partition(int[] array, int lowest, int highest) {
		int pivot = array[highest];
		int index = lowest - 1;
		int temp = 0;
		
		for (int i = lowest; i < highest; i++) {
			if (array[i] <= pivot) {
				index++;
				temp = array[index];
				array[index] = array[i];
				array[i] = temp;
			}
		}
		
		temp = array[index + 1];
		array[index + 1] = array[highest];
		array[highest] = temp;

		return index + 1;
	}
}
