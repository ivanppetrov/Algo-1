package task2.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import task2.solutions.BirthadyRanges;
import task2.solutions.Pair;

public class BdayRangesTests {
	static List<Integer> birthdaysList;
	static List<Pair> ranges;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int[] birhtdays = new int[]{5, 10, 6, 7, 3, 4, 5, 11, 21, 300, 15};
		birthdaysList = new ArrayList<Integer>();
		
		for (int i = 0; i < birhtdays.length; i++) {
			birthdaysList.add(birhtdays[i]);
		}
		
		Pair range1 = new Pair(4, 9);
		Pair range2 = new Pair(6, 7);
		Pair range3 = new Pair(200, 225);
		Pair range4 = new Pair(300, 365);
		ranges = new ArrayList<Pair>();
		
		ranges.add(range1);
		ranges.add(range2);
		ranges.add(range3);
		ranges.add(range4);
	}

	@Test
	public void test() {
		List<Integer> result = BirthadyRanges.countBirthdays(birthdaysList, ranges);
		
		assertArrayEquals(new Integer[]{5, 2, 0, 1}, result.toArray());
	}

}
