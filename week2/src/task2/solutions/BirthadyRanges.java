package task2.solutions;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import util.MyScanner;

public class BirthadyRanges {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static class Pair {
		private int start;
		private int end;
		
		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			if (start >= 0 && start <= 365) {
				this.start = start;
			} else {
				start = -1;
			}
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			if (end >= 0 && end <= 365) {
				this.end = end;
			} else {
				end = -1;
			}
		}
		
		
	}
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
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int people = sc.nextInt();
		int numberOfRanges = sc.nextInt();
		List<Integer> birthdays = new ArrayList<Integer>();
		
		for (int i = 0; i < people; i++) {
			birthdays.add(sc.nextInt());
		}
		
		List<Pair> ranges = new ArrayList<BirthadyRanges.Pair>();
		
		for (int i = 0; i < numberOfRanges; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			ranges.add(new Pair(start, end));
		}
		
		List<Integer> result = BirthadyRanges.countBirthdays(birthdays, ranges);
		
		for (Integer number : result) {
			out.println(number);
		}
		
		out.flush();
		out.close();
	}
}
