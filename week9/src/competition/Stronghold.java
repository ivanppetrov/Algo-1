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
			if (isLeaf(node) && currentValue.height != element.height) {
				return null;
			} else {
				if (currentValue.height > element.height) {
					return node;
				} else if (element.height < currentValue.height){
					node = lookUp(node.getLeft(), element);
				} else {
					node = lookUp(node.getRight(), element);
				}
				return node;
			}
		}
		
		public void remove(Wall element) {
			remove(this.root, element);
		}
		
		private Node remove(Node node, Wall element) {
			if (node == null) {
				return node;
			} else if (element.index < node.getValue().height) {
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
		
		private Node delete(Node node, Wall key) {
			  if (node == null) {
			   return null;
			  }

			  if (key.height < node.getValue().height) {
			   node.left = delete(node.left, key);

			  } else if (key.height > node.getValue().height) {
			   node.right = delete(node.right, key);
			  } else {
			   // zero or one child
			   if (node.right == null) {
			    return node.left;
			   }

			   // zero or one child
			   if (node.left == null) {
			    return node.right;
			   }

			   // left and right child
			   // get leftmost child from the right subtree and swap values
			   // recursively do the same for the leftmost children
			   Node temp = node;
			   node = getMinElement(temp.right);
			   node.right = deleteMinElement(temp.right);
			   node.left = temp.left;
			  }

			  return node;
			 }
		
		private Node deleteMinElement(Node x) {
			   if (x.left == null) {
			    return x.right;
			   }

			   x.left = deleteMinElement(x.left);

			   return x;
			  }
		public Node getMinElement(Node node) {
			   if (node.left == null) {
			    return node;

			   } else {
			    return getMinElement(node.left);
			   }
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
		
		for (int i = 0; i < size; i++) {
			tree.insert(new Wall(sc.nextInt(), i + 1));
		}
		
		int len = sc.nextInt();
		
		for (int i = 0; i < len; i++) {
			String[] commands = sc.nextLine().split("\\s+");
			
			if (commands[0].equals("shoot")) {
				Wall wall = tree.lookUp(new Wall(Integer.parseInt(commands[1]), 0)).getValue();
				out.println(wall != null ? wall.index : "MISS");
				tree.remove(wall);
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
