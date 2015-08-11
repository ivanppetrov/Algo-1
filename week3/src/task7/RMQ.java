package task7;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RMQ {
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
	static int[] biTree;
	static int size;
	
	public static void set(int index, int element) {
		int parent = index / 2;
		biTree[index] = element;
		
		while (parent > 0) {
			int left = biTree[2 * parent];
			int right = biTree[2 * parent + 1];
			int min =  left < right ? left : right;
			biTree[parent] = min;
			parent /= 2;
		}
	}
	
	public static int getMin(int start, int end) {
		if (end == size) {
			return biTree[1];
		} else {
			
		}
		return end;
		
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int len = sc.nextInt();
		size = (int) Math.pow(2, Math.ceil(Math.log(len) / Math.log(2)));
		int queries = sc.nextInt();
		biTree = new int[2 * size];
		
		for (int i = 0; i < len; i++) {
			int index = size + i;
			set(index, sc.nextInt());
		}
		
		for (int i = 0; i < biTree.length; i++) {
			out.printf("%d ", biTree[i]);
		}
		
		for (int i = 0; i < queries; i++) {
			String[] command = sc.nextLine().split("\\s+");
			
			if (command[0].equals("set")) {
				int index = Integer.parseInt(command[1]);
				int value = Integer.parseInt(command[2]);
				index += size - 1;
				set(index, value);
			} else {
				int start = Integer.parseInt(command[1]);
				int end = Integer.parseInt(command[2]);
				
				out.println(getMin(start, end));
			}
		}
		out.println();
		for (int i = 0; i < biTree.length; i++) {
			out.printf("%d ", biTree[i]);
		}
		
		out.flush();
		out.close();
	}

}
