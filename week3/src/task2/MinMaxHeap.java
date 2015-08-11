package task2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinMaxHeap {
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
	
	static int level = 1;
	static boolean isMinMaxHeap = true;
	
	public static void isMinMaxHeap(int[] array, int parent) {
		if (parent >= array.length) {
			level--;
			return;
		} else {
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;
			
			if (left < array.length) {			
				if (array[left] != 0) {
					if ((level % 2 != 0 && array[left] > array[parent]) || (level % 2 == 0 && array[left] < array[parent])) {
						level++;
						isMinMaxHeap(array, left);
					} else {
						level--;
						isMinMaxHeap = false;
						return;
					}
				}
			}
			
			if (right < array.length) {
				if (array[right] != 0) {
					if ((level % 2 != 0 && array[right] > array[parent]) || (level % 2 == 0 && array[right] < array[parent])) {
						level++;
						isMinMaxHeap(array, right);
					} else {
						level--;
						isMinMaxHeap = false;
						return;
					}
				}
			}
			level--;
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		
		isMinMaxHeap(array, 0);
		
		if (isMinMaxHeap) {
			out.print("YES");
		} else {
			out.print("NO");
		}
		
		out.flush();
		out.close();
	}

}
