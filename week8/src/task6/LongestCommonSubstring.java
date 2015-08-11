package task6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestCommonSubstring {
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
	
	public static String getLongestSubstr(String str1, String str2) {
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		int len1 = str1Arr.length;
		int len2 = str2Arr.length;
		int[][] result = new int[len1][len2];
		int max = 0;
		int index = 0;
		int index2 = 0;
		
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (i > -1 && j > -1) {
					if (str1Arr[i] == str2Arr[j]) {
						int value = result[i - 1][j - 1] + 1;
						result[i][j] = value;
						if (max < value) {
							max = value;
							index = i;
							index2 = j;
						}
					} else {
						result[i][j] = 0;
					}
				}
			}
		}
		
		return str1.substring(index - max + 1, index + 1) + "\n" + str2.substring(index2 - max + 1, index2 + 1);
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		out.print(getLongestSubstr(str1, str2));
		out.flush();
		out.close();
	}

}
