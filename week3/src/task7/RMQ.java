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
	
	public static int getMin(int left, int right) {
		int lMin = biTree[left];
		int rMin = biTree[right];
		
		while (left < right) {
			if (right - left == 1) {
				break;
			}
			
			//if left is left child
			if (left % 2 == 0) {
				//left == left parent
				left /= 2;
				lMin = Math.min(lMin, biTree[left]);
			} else {	//if left pointer is right child
				int temp = Math.min(lMin, biTree[left]);
				left = (left + 1) /2;
				lMin = Math.min(temp, biTree[left]);
			}
			
			//if right is left child
			if (right % 2 == 0) {
				int temp = Math.min(rMin, biTree[right]);
				right = (right - 1) /2;
                rMin = Math.min(temp, biTree[right]);
			} else {	//if right is right child
				right /= 2;
				rMin = Math.min(rMin, biTree[right]);
			}
		}
		
		return Math.min(lMin, rMin);
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
		
		for (int i = 0; i < queries; i++) {
			String[] command = sc.nextLine().split("\\s+");
			
			if (command[0].equals("set")) {
				int index = Integer.parseInt(command[1]);
				int value = Integer.parseInt(command[2]);
				index += size;
				set(index, value);
			} else {
				int start = Integer.parseInt(command[1]) + size;
				int end = Integer.parseInt(command[2]) + size;
				
				out.println(getMin(start, end));
			}
		}
		out.flush();
		out.close();
	}

}
