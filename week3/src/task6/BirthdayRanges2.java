package task6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BirthdayRanges2 {
	//index tree
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
	
	static class Pair {
		int date;
		int numbers;
		
		public Pair(int date, int numbers) {
			this.date = date;
			this.numbers = numbers;
		}
	}
	
	static class Node {
		private Pair value;
		private Node left;
		private Node right;
		
		public Node() {
			this.value = new Pair(-1, 0);
			this.left = null;
			this.right = null;
		}
		
		public Node(Pair value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Pair getValue() {
			return value;
		}

		public void setValue(Pair value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	static class BinarySearchTree {
		private Node root;
		
		public BinarySearchTree() {
			this.root = null;
		}
		
		public Node getRoot() {
			return this.root;
		}
		
		public void setLeft(Node left) {
			this.root.setLeft(left);
		}
		
		public Node getLeft() {
			return this.root.getLeft();
		}
		
		public void setRight(Node right) {
			this.root.setRight(right);
		}
		
		public Node getRight() {
			return this.root.getRight();
		}
		
		public boolean isLeaf(Node node) {
			return node.getLeft() == null && node.getRight() == null;
		}
		
		public void insert(Pair element) {
			this.root = insertAfter(this.root, element);
		}
		
		private Node insertAfter(Node node, Pair element) {
			if (node == null) {
				node = new Node(element);
			} else {
				if (element.date < node.getValue().date) {
					node.setLeft(insertAfter(node.getLeft(), element));
				} else if (element.date > node.getValue().date) {
					node.setRight(insertAfter(node.getRight(), element)) ;
				} else {
					Pair temp = node.getValue();
					int numbers = temp.numbers + element.numbers;
					temp.numbers = numbers;
					node.setValue(temp);
				}
			}
			return node;
		}
		
		public Node lookUp(int element) {
			return lookUp(this.root, element);
		}
		
		private Node lookUp(Node node, int element) {
			if (node == null) {
				return null;
			}
			int currentValue = node.getValue().date;
			if (isLeaf(node) && currentValue != element) {
				return null;
			} else {
				if (currentValue == element) {
					return node;
				} else if (element < currentValue){
					node = lookUp(node.getLeft(), element);
				} else {
					node = lookUp(node.getRight(), element);
				}
				return node;
			}
		}
		
		public void remove(Pair element) {
			remove(this.root, element);
		}
		
		private void remove(Node node, Pair element) {
			if (node == null) {
				return;
			}
			Pair currentValue = node.getValue();
			if (currentValue.date == element.date) {
				int numbers = currentValue.numbers - element.numbers;
				if (numbers < 0) {
					numbers = 0;
				}
				currentValue.numbers = numbers;
				node.setValue(currentValue);
			} else if (element.date < currentValue.date){
				remove(node.getLeft(), element);
			} else {
				remove(node.getRight(), element);
			}
		}
		
		public void traverse() {
			goTo(this.root);
		}
		
		private void goTo(Node node) {	
			if(node == null) {
				return;
			}
			
			goTo(node.getLeft());
			
			System.out.printf("%s ", node.getValue());
			
			goTo(node.getRight());
		}
	}

	static int[] biTree;
	static int SIZE = 512;
	
	public static void insert(int index, int element) {
		int parent = index / 2;
		while (parent > 0) {
			biTree[parent] += element;
			parent /= 2;
		}
		
		biTree[index] += element;
	}
	
	public static void update(int index, int value) {
		int current = biTree[index];
		if (value < 0) {
			value = current + value < 0 ? -current : value;
			biTree[index] += value;
		} else {
			biTree[index] += value;
		}
		
		int parent = index / 2;
		
		while (parent > 0) {
			biTree[parent] += value;
			parent /= 2;
		}
	}
	
	public static int getMin(int index) {
		if (index == 2 * SIZE) {
			return biTree[1];
		} else {
			int sum = 0;
//			index += 1;
			
			while (index != 1) {
				int parent = index / 2;
				//is right child
				if (index == 2 * parent + 1) {
					sum += biTree[2 * parent];
				}
				index = parent;
			}
			return sum;
		}
		
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int days = sc.nextInt();
		int commands = sc.nextInt();
		biTree = new int[2 * SIZE];
//		BinarySearchTree tree = new BinarySearchTree();
//		
//		for (int i = 0; i < days; i++) {
//			tree.insert(new Pair(sc.nextInt(), 1));
//		}
//		
//		for (int i = 0; i < commands; i++) {
//			String[] command = sc.nextLine().split("\\s+");
//			
//			if (command[0].equals("add")) {
//				tree.insert(new Pair(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
//			} else if (command[0].equals("remove")) {
//				tree.remove(new Pair(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
//			} else {
//				int start = Integer.parseInt(command[1]);
//				int end = Integer.parseInt(command[2]);
//				int count = 0;
//				
//				for (int j = start; j <= end; j++) {
//					Node node = tree.lookUp(j);
//					
//					if (node != null) {
//						count += node.getValue().numbers;
//					}
//				}
//				
//				out.println(count);
//			}
//		}
		
		for (int i = 0; i < days; i++) {
			int index = SIZE + sc.nextInt();
			insert(index, 1);
		}
		
		for (int i = 0; i < commands; i++) {
			String[] command = sc.nextLine().split("\\s+");
			
			if (command[0].equals("count")) { 
				int start = Integer.parseInt(command[1]);
				int end = Integer.parseInt(command[2]);
				start += SIZE;
				end += SIZE + 1;
				
				int sumToStart = getMin(start);
				int sumToEnd = getMin(end);
				out.println(Math.abs(sumToEnd - sumToStart));
			}else {
				int index = Integer.parseInt(command[1]);
				int value = Integer.parseInt(command[2]);
				index += SIZE;
				if (command[0].equals("add")) {
					update(index, value);
				} else {
					update(index, -value);
				}
				
			}
		}
		
		out.flush();
		out.close();
	}

}
