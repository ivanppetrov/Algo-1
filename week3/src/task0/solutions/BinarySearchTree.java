package task0.solutions;

public class BinarySearchTree {
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
	
	public void insert(int element) {
		this.root = insertAfter(this.root, element);
	}
	
	private Node insertAfter(Node node, int element) {
		if (node == null) {
			node = new Node(element);
		} else {
			if (element <= node.getValue() ) {
				node.setLeft(insertAfter(node.getLeft(), element));
			} else {
				node.setRight(insertAfter(node.getRight(), element)) ;
			}
		}
		return node;
	}
	
	public Node lookUp(int element) {
		return lookUp(this.root, element);
	}
	
	private Node lookUp(Node node, int element) {
		int currentValue = node.getValue();
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
	
	public void remove(int element) {
		remove(this.root, element);
	}
	
	private Node remove(Node node, int element) {
		if (node == null) {
			return node;
		} else if (element < node.getValue()) {
			node.setLeft(remove(node.getLeft(), element));
		} else if (element > node.getValue()) {
			node.setRight(remove(node.getRight(), element));
		} else {
			if (isLeaf(node)) {
				node = null;
			} else if (node.getLeft() == null) {
				node = node.getRight();
			} else if (node.getRight() == null) {
				node = node.getLeft();
			} else {
				int min = findMin(node.getRight()).getValue();
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
		
		System.out.printf("%s ", node.getValue());
		
		goTo(node.getRight());
	}
}
