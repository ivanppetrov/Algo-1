package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListProblems {
	
	public static List<Integer> sort(List<Integer> list) {
		List<Integer> sortedList = new ArrayList<Integer>(list);
		Collections.sort(sortedList);		
		
		return sortedList;
	}
	
	public static List<Integer> reverse(List<Integer> list) {
		List<Integer> reversed = new ArrayList<Integer>(list);
		Collections.reverse(reversed);
		
		return reversed;
	}
	
	public static boolean isMonotonous(List<Integer> list) {
		return sort(list).equals(list) || reverse(sort(list)).equals(list);
	}
}
