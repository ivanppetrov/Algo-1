package task2.tests;

import java.util.ArrayList;
import java.util.List;

import task2.solutions.BirthadyRanges;
import task2.solutions.Pair;

public class Tests {

	public static void main(String[] args) {
		int[] array = new int[]{1, 3, 14, 5, 3, 1, 7, 7, 3, 14};
		List<Integer> birthdays = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			birthdays.add(array[i]);
		}
		
		Pair pair = new Pair(2, 7);
		List<Pair> ranges = new ArrayList<Pair>();
		ranges.add(pair);
		List<Integer> result = BirthadyRanges.countBirthdays(birthdays, ranges);
		
		for (Integer number : result) {
			System.out.printf("[%d ]", number);
		}

	}

}