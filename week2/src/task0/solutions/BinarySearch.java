package task0.solutions;

public class BinarySearch {
	public static int binarySearch(int[] array, int element, int left, int right) {
		if (left == right) {
			if (array[left] == element) {
				return left;
			} else {
				return -1;
			}
		} else {
			int mid = left + (right - left) / 2;
			if (element <= array[mid]) {
				return binarySearch(array, element, left, mid);
			} else{
				return binarySearch(array, element, mid + 1, right);
			}
		}
	}
}
