package task5;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Thieves {
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
	static int[][] result;
	static int capacity;
	
	public static int getMaxValue(int[] weights, int[] values) {
		for (int i = 0; i <= capacity; i++) {	//i - current capacity
			for (int j = 0; j <= capacity; j++) {	//j - index if item
				if (j - 1 >= 0) {
					int tempWeight = weights[j - 1];
					if (i - 1 >= 0 && j - tempWeight > 0) {
						int tempCapacity = j - weights[j] + values[i - 1];	
						
						result[j][i] = Math.max(tempCapacity, result[i][j - tempWeight]);
					}
				} else {
					result[j][i] = 0;
				}
				
			}
		}
		
		return result[capacity][capacity];
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int items = sc.nextInt();
		capacity = sc.nextInt();
		
		result = new int[capacity + 1][capacity + 1];
		int[] weights = new int[items + 1];
		int[] values = new int[items + 1];
		
		for (int i = 1; i <= items; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		out.print(getMaxValue(weights, values));
		out.flush();
		out.close();
	}

}
