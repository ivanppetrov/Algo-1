package task2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestSubsequence {
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
	static int[] path;
	
	public static int getLongestSubs(int[] array) {
		int[] len = new int[array.length];
		len[0] = 1;
		
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] < array[i] && len[i] <= len[j]) {
					len[i] = len[j] + 1;
					path[i] = j;
				} else {
					if (len[i] < len[j]) {
						len[i] = 1;
					}
				}
			}
		}
		int max = 0;
		
		for (int i = 0; i < len.length; i++) {
			if (len[i] > max) {
				max = len[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		int[] array = new int[size];
		path = new int[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		
		out.println(getLongestSubs(array));
		for (int i = 0; i < array.length; i++) {
			out.printf("%d ", path[i]);
		}
		out.flush();
		out.close();
	}

}
