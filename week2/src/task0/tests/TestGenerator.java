package task0.tests;

import java.util.Random;

public class TestGenerator {	
	public static int[] generateTestArray(int size) {
		Random random = new Random();
		int[] result = new int[size];
		int element = 0;
				
		for (int i = 0; i < size; i++) {
			int number = random.nextInt(size);
			element += number;
			result[i] =  element;
		}
		
		return result;
	}
	
	public static int isContain(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		
		return -1;
	}
}
