package task4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaxBannana {
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
	static int size;
	
	public static int getMaxBannana(int[][] grid) {
		
		for (int i = size - 1; i >= 0 ; i--) {
			for (int j = 0; j < size; j++) {
				if (i + 1 == size) {
					if (j != 0) {
						result[i][j] = result[i][j - 1] + grid[i][j];
					} else {
						result[i][j] = grid[i][j];
					}
				} else {
					if (j != 0) {
						result[i][j] = Math.max(result[i][j - 1], result[i + 1][j]) + grid[i][j];
					} else {
						result[i][j] = result[i + 1][j] + grid[i][j];
					}
					
				}
			}
		}
		
		return result[0][size - 1];
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		size = sc.nextInt();
		int[][] grid = new int[size][size];
		result = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		out.print(getMaxBannana(grid));
		out.flush();
		out.close();
	}

}
