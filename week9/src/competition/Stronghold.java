package competition;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Stronghold {
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
	static class Wall {
		int height;
		int index;
		
		public Wall(int height, int index) {
			this.height = height;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return height + " " + index;
		}
	}
	
	static class Node {
		private Wall value;
		private Node left;
		private Node right;
		
		public Node() {
			this.value = new Wall(0, 0);
			this.left = null;
			this.right = null;
		}
		
		public Node(Wall value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Wall getValue() {
			return value;
		}

		public void setValue(Wall value) {
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
		
		public void insert(Wall element) {
			this.root = insertAfter(this.root, element);
		}
		
		private Node insertAfter(Node node, Wall element) {
			if (node == null) {
				node = new Node(element);
			} else {
				if (element.height < node.getValue().height) {
					node.setLeft(insertAfter(node.getLeft(), element));
				} else if (element.height > node.getValue().height) {
					node.setRight(insertAfter(node.getRight(), element)) ;
				} else {
					Wall contact = node.getValue();
					contact.index = element.index;
					node.setValue(contact);
				}
			}
			return node;
		}
		
		public Node lookUp(Wall element) {
			return lookUp(this.root, element);
		}
		
		private Node lookUp(Node node, Wall element) {
			if (node == null) {
				return null;
			}
			
			Wall currentValue = node.getValue();
			if (currentValue.height > element.height) {
				return node;
			} else {
				node = lookUp(node.getRight(), element);
			}
			
			return node;
			
		}
		
		public void remove(Wall element) {
			remove(this.root, element);
		}
		
		private Node remove(Node node, Wall element) {
			if (node == null) {
				return node;
			} else if (element.height < node.getValue().height) {
				node.setLeft(remove(node.getLeft(), element));
			} else if (element.height > node.getValue().height) {
				node.setRight(remove(node.getRight(), element));
			} else {
				if (isLeaf(node)) {
					node = null;
				} else if (node.getLeft() == null) {
					node = node.getRight();
				} else if (node.getRight() == null) {
					node = node.getLeft();
				} else {
					Wall min = findMin(node.getRight()).getValue();
					node.setRight(remove(node.getRight(), min));
					node.setValue(min);
				}
			}
			
			return node;
		}
		
		private Node findMin(Node node) {
			if (node == null) {
				return null;
			} else if (node.getLeft() == null) {
				return node;
			} else {
				return findMin(node.getLeft());
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
			
			out.println(node.getValue().height + " " + node.getValue().index);
			
			goTo(node.getRight());
		}
		
		@Override
		public String toString() {
			return root + " " + getLeft() + " " + getRight();
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		BinarySearchTree tree = new BinarySearchTree();
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			int value = sc.nextInt();
			array[i] = value;
			tree.insert(new Wall(value, i + 1));
		}
		
		int len = sc.nextInt();
		
		for (int i = 0; i < len; i++) {
			String[] commands = sc.nextLine().split("\\s+");
			
			if (commands[0].equals("shoot")) {
				Node node = tree.lookUp(new Wall(Integer.parseInt(commands[1]), Integer.MAX_VALUE));
				if (node != null) {
					out.println(node.getValue().index);
					tree.remove(node.getValue());
				} else {
					out.println("MISS");
				}
			} else {
				int index = Integer.parseInt(commands[1]); 
				int height = Integer.parseInt(commands[2]);
				tree.insert(new Wall(height, index));
			}
		}
		
		out.flush();
		out.close();

	}

}
