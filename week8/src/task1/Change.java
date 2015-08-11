package task1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Change {
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
	static final int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100};
	
	public static int getNumberOfSum(int sum) {
		int[] array = new int[sum + 1];
		array[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 0; i < array.length; i++) {
				int index = i + coins[j];
				if (index <= sum) {
					array[index] = array[i] + array[index];
				}
			}
		}
		
		return array[sum];
	}
	
	//no duplicated coins 
	public static int getNumberOfSumUnique(int sum) {
		int[] array = new int[sum + 1];
		array[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = array.length - 1; i >= 0; i--) {
				int index = i + coins[j];
				if (index <= sum) {
					array[index] = array[i] + array[index];
				}
			}
		}
		
		return array[sum];
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int sum = sc.nextInt();
		
		out.println(getNumberOfSum(sum));
		out.print(getNumberOfSumUnique(sum));
		out.flush();
		out.close();
	}

}
