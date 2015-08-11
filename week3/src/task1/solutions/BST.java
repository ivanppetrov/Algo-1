package task1.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import task0.solutions.Node;

public class BST {
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
	public static boolean isBST = true;
	
	public static boolean isBST(Node node) {
		return checkNodes(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean checkNodes(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		
		if (node.getValue() <= min || node.getValue() > max) {
			return false;
		}
		
		return checkNodes(node.getLeft(), min, node.getValue()) && checkNodes(node.getRight(), node.getValue(), max);
	}
	
	public static void isBST(int[] array, int parent) {
		if (parent >= array.length) {
			return;
		} else {
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;
			
			if (left >= array.length) {
				return;
			}
			
			if (array[left] != 0) {
				if (array[left] < array[parent]) {
					isBST(array, left);
				} else {
					isBST = false;
					return;
				}
			}
			
			if (right >= array.length) {
				return;
			}
			
			if (array[right] != 0) {
				if (array[right] > array[parent]) {
					isBST(array, right);
				} else {
					isBST = false;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		
		isBST(array, 0);
		
		if (isBST) {
			out.print("YES");
		} else {
			out.print("NO");
		}
		
		out.flush();
		out.close();
	}
}
