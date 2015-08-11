package task7.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import task0.solutions.BinaryHeap;

public class KMin {
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
	
	public static int kthMinimum(List<Integer> list, int k) {
		//insert always k  elements in heap
		BinaryHeap heap = new BinaryHeap();
		
		for (int i = 0; i < k; i++) {
			heap.insertMax(list.get(i));
		}
		
		for (int i = k ; i < list.size(); i++) {
			int current = list.get(i);
			if (heap.getTop() > current) {
				heap.removeMax();
				heap.insertMax(current);
			}
		}
		
		return heap.getTop();
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			list.add(sc.nextInt());
		}
		
		out.print(kthMinimum(list, k));
		
		out.flush();
		out.close();
	}
}
