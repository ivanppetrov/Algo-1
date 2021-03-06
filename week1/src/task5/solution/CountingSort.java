package task5.solution;

public class CountingSort {
	public static int[] sort(int[] array, int maxValue) {
		int[] histogram = new int[maxValue + 1];
		
		//get the histogram
 		for (int i = 0; i < array.length; i++) {
			histogram[array[i]] += 1;
		}
 		
 		//calculate index for each element
 		int currentIndex = 0;
 		for (int i = 0; i <= maxValue; i++) {
			int index = histogram[i];
			histogram[i] = currentIndex;
			currentIndex += index;
		}
 		
 		//sort the array
 		int[] result = new int[array.length];
 		for (int i = 0; i < array.length; i++) {
			result[histogram[array[i]]] = array[i];
			histogram[array[i]] += 1;
		}
 		
 		return result;
	}
}
