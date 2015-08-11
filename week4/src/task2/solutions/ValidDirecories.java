package task2.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ValidDirecories {
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

	private boolean[] visited;
	private boolean[] currentPath;
	private int length;
	
	public ValidDirecories(int length) {
		visited = new boolean[length];
		currentPath = new boolean[length];
		this.length = length;
	}
	
	public boolean validateDirectories(int[][] directories, int index) {
		if (index == length) {
			return true;
		}
		
		visited[index] = true;
		currentPath[index] = true;
		
		for (int i = 0; i < length; i++) {
			int type = directories[index][i];
			
			if (type == 1) {
				if (!visited[i]) {
					return validateDirectories(directories, i);
				} else {
					if (currentPath[i]) {
						return false;
					}
				}
			}
		}
		currentPath[index] = false;
		
		return validateDirectories(directories, index + 1);
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int length = sc.nextInt();
		int[][] directories = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				directories[i][j] = sc.nextInt();
			}
		}
		
		ValidDirecories validDir = new  ValidDirecories(length);
		
		out.print(validDir.validateDirectories(directories, 0));
		
		out.flush();
		out.close();
	}
}
