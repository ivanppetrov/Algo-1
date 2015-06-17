package task2.solutions;

import java.util.ArrayList;
import java.util.List;

public class BirthadyRanges {
	public static List<Integer> countBirthdays(List<Integer> birthdays, List<Pair> ranges) {
		List<Integer> result = new ArrayList<Integer>();
		int[] histogram = new int[366];
		
		for (int i = 0; i < birthdays.size(); i++) {
			histogram[birthdays.get(i)]++;
		}
		
		for (Pair pair : ranges) {
			int count = 0;
			for (int i = pair.getStart(); i <= pair.getEnd(); i++) {
				count += histogram[i];
			}
			result.add(count);
		}
		
		return result;
	}
}