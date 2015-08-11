package task4;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quadruplets2 {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static class MyScanner {
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
	
	static int [] arr1, arr2, arr3, arr4;
	static int size;
	
	public static int getQuadrupletsCoutn() {
		Map<Integer, Integer> first = new HashMap<Integer, Integer>();
		Map<Integer, Integer> second = new HashMap<Integer, Integer>();
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int valueFirst = first.get(arr1[i] + arr2[j]) != null ? first.get(arr1[i] + arr2[j]) : 0;
				int secondFirst = second.get(arr3[i] + arr4[j]) != null ? second.get(arr3[i] + arr4[j]) : 0;
				first.put(arr1[i] + arr2[j], ++valueFirst);
				second.put(arr3[i] + arr4[j], ++secondFirst);
			}
		}
		
		for (Integer key : second.keySet()) {
			if (first.get(-key) != null) {
				count += first.get(-key) * second.get(key);
			}
		}
		
		
		return count;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		size = sc.nextInt();
		
		arr1 = new int[size];
		arr2 = new int[size];
		arr3 = new int[size];
		arr4 = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for (int i = 0; i < size; i++) {
			arr2[i] = sc.nextInt();
		}
		
		for (int i = 0; i < size; i++) {
			arr3[i] = sc.nextInt();
		}
		
		for (int i = 0; i < size; i++) {
			arr4[i] = sc.nextInt();
		}
		
		out.print(getQuadrupletsCoutn());
		
		out.flush();
		out.close();
	}

}
