package task4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PhoneBook2 {
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
	static class Contact {
		String name;
		String number;
		
		public Contact(String name, String number) {
			this.name = name;
			this.number = number;
		}
		
		@Override
		public String toString() {
			return name + " " + number;
		}
	}
	
	static class Node {
		private Contact value;
		private Node left;
		private Node right;
		
		public Node() {
			this.value = new Contact("", "");
			this.left = null;
			this.right = null;
		}
		
		public Node(Contact value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Contact getValue() {
			return value;
		}

		public void setValue(Contact value) {
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
		
		public void insert(Contact element) {
			this.root = insertAfter(this.root, element);
		}
		
		private Node insertAfter(Node node, Contact element) {
			if (node == null) {
				node = new Node(element);
			} else {
				if (element.name.compareTo(node.getValue().name) < 0) {
					node.setLeft(insertAfter(node.getLeft(), element));
				} else if (element.name.compareTo(node.getValue().name) > 0) {
					node.setRight(insertAfter(node.getRight(), element)) ;
				} else {
					Contact contact = node.getValue();
					contact.number = element.number;
					node.setValue(contact);
				}
			}
			return node;
		}
		
		public Node lookUp(Contact element) {
			return lookUp(this.root, element);
		}
		
		private Node lookUp(Node node, Contact element) {
			if (node == null) {
				return null;
			}
			Contact currentValue = node.getValue();
			if (isLeaf(node) && !currentValue.name.equals(element.name)) {
				return null;
			} else {
				if (currentValue.name.compareTo(element.name) == 0) {
					return node;
				} else if (element.name.compareTo(currentValue.name) < 0){
					node = lookUp(node.getLeft(), element);
				} else {
					node = lookUp(node.getRight(), element);
				}
				return node;
			}
		}
		
		public void remove(Contact element) {
			remove(this.root, element);
		}
		
		private Node remove(Node node, Contact element) {			
			if (node == null) {
				return node;
			} else if (element.name.compareTo(node.getValue().name) < 0) {
				node.setLeft(remove(node.getLeft(), element));
			} else if (element.name.compareTo(node.getValue().name) > 0) {
				node.setRight(remove(node.getRight(), element));
			} else {
				if (isLeaf(node)) {
					node = null;
				} else if (node.getLeft() == null) {
					node = node.getRight();
				} else if (node.getRight() == null) {
					node = node.getLeft();
				} else {
					Contact min = findMin(node.getRight()).getValue();
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
			
			out.println(node.getValue().name + " " + node.getValue().number);
			
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
		
		for (int i = 0; i < size; i++) {
			String[] commands = sc.nextLine().split("\\s+");
			
			if (commands[0].equals("insert")) {
				tree.insert(new Contact(commands[2], commands[1]));
			} else if (commands[0].equals("lookup")) {
				Node node = tree.lookUp(new Contact(commands[1], ""));
				
				if (node == null) {
					out.println("NOT FOUND!");
				} else {
					out.println(node.value.number);
				}
			} else if (commands[0].equals("remove")) {
				tree.remove(new Contact(commands[1], ""));
			} else {
				tree.traverse();
			}
		}
		
		out.flush();
		out.close();
	}

}
