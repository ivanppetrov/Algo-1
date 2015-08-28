package task1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WordDictionary {
	private static final int SIZE = 128;
	private static final String INSERT = "insert";
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

	
	static class Node {
		int value;
		boolean isWord;
		Node[] next;
		
		public Node() {
			this.value = -1;
			this.isWord = false;
			this.next = new Node[SIZE];
		}

		public Node(int value, boolean isWord, Node[] next) {
			super();
			this.value = value;
			this.isWord = isWord;
			this.next = next;
		}
	}
	
	Node root;
	Node current;
	
	public void insertWord(String word) {
		int i = 0;
		int len = word.length();
		current = root;
		
		while (i < len) {
			int ch = word.charAt(i);
			
			if (current.next[ch] == null) {
				current.next[ch] = new Node(ch, false, new Node[SIZE]);
			}
			
			current = current.next[ch];
			i++;
		}
		
		current.isWord = true;
	}
	
	public boolean contains(String word) {
		int i = 0;
		int len = word.length();
		current = root;
		
		while (i < len) {
			int ch = word.charAt(i);
			
			if (current.next[ch] != null) {
				current = current.next[ch];
				
				if (current.value == ch) {
					i++;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return current.isWord;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		WordDictionary wd = new WordDictionary();
		wd.root = new Node();
		
		int command = sc.nextInt();
		
		for (int i = 0; i < command; i++) {
			String[] input = sc.nextLine().split("\\s+");
			
			if (input[0].equals(INSERT)) {
				wd.insertWord(input[1]);
			} else {
				out.println(wd.contains(input[1]));
			}
		}
		
		out.flush();
		out.close();
	}

}
