package task2.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import task0.solutions.BinarySearch;

public class BirthadyRanges {

	public static List<Integer> countBirthdays(List<Integer> birthdays, List<Pair> ranges) {
		List<Integer> result = new ArrayList<Integer>();

		int[] bdayHistogram = new int[366];
		
		for (Integer bday : birthdays) {
			bdayHistogram[bday]++;
		}
		
		for (int i = 1; i < bdayHistogram.length; i++) {
			bdayHistogram[i] += bdayHistogram[i - 1];
		}
		
		
		for (Pair pair : ranges) {
			int start = 0, end = 0;
			
			if (pair.getStart() == 0) {
				start = bdayHistogram[pair.getStart()];
			} else {
				start = bdayHistogram[pair.getStart() - 1];
			}
			
			end = bdayHistogram[pair.getEnd()];
			
			result.add(end - start);
		}
		
		return result;
	}
}
