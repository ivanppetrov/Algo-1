package task4.solutions;

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

public class BuildScripts {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
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
	
	public Stack<Integer> path;
	public List<Integer> resultIndex;
	public boolean[] visited;
	public boolean[] currentPath;
	public int length;
	public boolean isValid;
	
	public BuildScripts(int length) {
		this.length = length;
		path = new Stack<Integer>();
		resultIndex = new ArrayList<Integer>();
		visited = new boolean[length];
		currentPath = new boolean[length];
		isValid = true;
	}
	
	public void validateBuilds(List<List<Integer>> buildDependencies, int current) {
		if (current == this.length) {
			return;
		}
		List<Integer> currentList = buildDependencies.get(current);
		if (currentList.isEmpty()) {
			visited[current] = true;
			resultIndex.add(current);
			return;
		}
		
		visited[current] = true;
		currentPath[current] = true;
		path.push(current);
		
		for (int i = 0; i < currentList.size(); i++) {
			int temp = currentList.get(i);
			if(!visited[currentList.get(i)]) {
				validateBuilds(buildDependencies, currentList.get(i));
			} else {
				if (currentPath[currentList.get(i)]) {
					isValid = false;
				}
			}
		}
		
		resultIndex.add(path.pop());
		currentPath[current] = false;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int length = Integer.parseInt(sc.nextLine());
		BuildScripts bs = new BuildScripts(length);
		String[] inputList = sc.nextLine().split("\\s+");
		Map<String, Integer> inputMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < inputList.length; i++) {
			inputMap.put(inputList[i], i);
		}
		
		String start = sc.nextLine();
		List<List<Integer>> buildsDepend = new ArrayList<List<Integer>>();
		
		while (length > 0) {
			length--;
			List<Integer> depend = new ArrayList<Integer>();
			String[] inputDepend = sc.nextLine().split("\\s+");
			
			for (int i = 1; i <= Integer.parseInt(inputDepend[0]); i++) {
				depend.add(inputMap.get(inputDepend[i]));
			}
			
			buildsDepend.add(depend);
		}
		
		bs.validateBuilds(buildsDepend, inputMap.get(start));
		
		if (bs.isValid) {
			for (int index : bs.resultIndex) {
				out.printf("%s ", inputList[index]);
				
			}
		} else {
			out.print("BUILD ERROR");
		}
		out.flush();
		out.close();
	}
}
