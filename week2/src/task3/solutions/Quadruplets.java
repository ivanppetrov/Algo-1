package task3.solutions;

import java.util.Arrays;

import task0.solutions.BinarySearch;

public class Quadruplets {
	public static int zeroQuadrupletsCount(int[] a, int[] b, int[] c, int[] d) {
		int result = 0;
		int size = a.length * b.length;
		int[] firstSum = new int[size];
		int[] secondSum = new int[size];
		int index = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				firstSum[index] = a[i] + b[j];
				secondSum[index] = c[i] + d[j];
				index++;
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (firstSum[i] + secondSum[j] == 0) {
					result++;
				}
			}
		}
		
		return result;
	}
}
