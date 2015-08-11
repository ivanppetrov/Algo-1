package task3.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class PhoneNumbers {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	static class MyScanner {
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

	
	public int numberOfCalls;
	public int numberOfStudents;
	public boolean[] visited;
	public Stack<Integer> currentPath;
	
	public PhoneNumbers(int number) {
		numberOfCalls = 0;
		numberOfStudents = number;
		visited = new boolean[number];
		currentPath = new Stack<Integer>();
	}
	
	public void saveBill(List<List<Integer>> studentsLinks, int student) {
		if (student == numberOfStudents) {
			return;
		}
		if (currentPath.isEmpty() && !visited[student]) {
			numberOfCalls++;
		}
		
		if (!visited[student]) {
			List<Integer> studentFriends = studentsLinks.get(student);
			
			visited[student] = true;
			currentPath.push(student);
			
			for (int i = 0; i < studentFriends.size(); i++) {
				int current = studentFriends.get(i);
				if (!visited[current]) {
					saveBill(studentsLinks, current);
				}
			}
			
			currentPath.pop();
			if (!currentPath.empty()) {
				return;
			}
			saveBill(studentsLinks, student + 1);
		} else {
			saveBill(studentsLinks, student + 1);
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int numberOfStudents = sc.nextInt();
		PhoneNumbers pn = new PhoneNumbers(numberOfStudents);
		String[] studentsList = sc.nextLine().split("\\s+");
		Map<Integer, Integer> studentsMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < studentsList.length; i++) {
			studentsMap.put(Integer.parseInt(studentsList[i]), i);
		}
		
		List<List<Integer>> studentsLinks = new ArrayList<List<Integer>>();
		
		while (numberOfStudents > 0) {
			numberOfStudents--;
			List<Integer> friends = new ArrayList<Integer>();
			int friendsNumber = sc.nextInt();
			
			for (int i = 0; i < friendsNumber; i++) {
				friends.add(studentsMap.get(sc.nextInt()));
			}
			
			studentsLinks.add(friends);
		}
		
		
		pn.saveBill(studentsLinks, 0);
		
		out.print(pn.numberOfCalls);
		
		out.flush();
		out.close();
	}
}
