package competition;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestBuildingArea {
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
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		int[][] area = new int[size][size];
		int[][] subArea = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			char[] input = sc.nextLine().toCharArray();
			
			for (int j = 0; j < input.length; j++) {
				int value = 0;
				if (input[j] == 'O') {
					value = 1;
				}
				area[i][j] = value;
			}
		}
		
		for (int i = 0; i < size; i++) {
			subArea[0][i] = area[0][i];
			subArea[i][0] = area [i][0];
		}
		int max = 0;
		
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				if (area[i][j] == 1) {
					int temp = Math.min(subArea[i][j-1], subArea[i-1][j]);
					int min = Math.min(temp, subArea[i-1][j-1]) + 1;
					max = max < min ? min : max;
					subArea[i][j] = min;
				} else {
					subArea[i][j] = 0;
				}
			}
		}
		
		out.print(max);
		out.flush();
		out.close();
	}
}
