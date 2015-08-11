package task4.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import task0.solutions.BinarySearch;
import util.MyScanner;

public class PhoneBook {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	static public class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      public String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      public int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      public long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      public double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      public String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }
	}
	
	public static class Contact {
		private String name;
		private int number;
		
		public Contact(int number, String name) {
			super();
			this.name = name;
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
	}

	
	public static List<String> lookupNames(List<Contact> phoneBook, List<Integer> numbers) {
		List<String> result = new ArrayList<String>();
		int[] phoneBookNumbers = new int[phoneBook.size()];
		int index = 0;
		
		for (Contact contac : phoneBook) {
			phoneBookNumbers[index++] = contac.getNumber();
		}
		 
		for (Integer number : numbers) {
			int position = binarySearch(phoneBookNumbers, number, 0, phoneBookNumbers.length - 1);
			
			if (position >= 0) {
				result.add(phoneBook.get(position).getName());
			}
		}
		
		return result;
	}
	
	private static int binarySearch(int[] array, int element, int left, int right) {
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
	
	public static void main(String[] args) {
		MyScanner sc  = new MyScanner();
		
		int contacts = sc.nextInt();
		int numbers = sc.nextInt();
		
		List<Contact> phoneBook = new ArrayList<PhoneBook.Contact>();
		
		for (int i = 0; i < contacts; i++) {
			String[] input = sc.nextLine().split("\\s+");
			phoneBook.add(new Contact(Integer.parseInt(input[0]), input[1]));
		}
		Comparator<Contact> compare = new Comparator<PhoneBook.Contact>() {
			
			@Override
			public int compare(Contact o1, Contact o2) {
				if (o1.getNumber() < o2.getNumber()) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		Collections.sort(phoneBook, compare);
		List<Integer> numbersList = new ArrayList<Integer>();
		
		for (int i = 0; i < numbers; i++) {
			numbersList.add(sc.nextInt());
		}
		
		List<String> names = PhoneBook.lookupNames(phoneBook, numbersList);
		
		for (String name : names) {
			out.println(name);
		}
		
		out.flush();
		out.close();
	}
}
