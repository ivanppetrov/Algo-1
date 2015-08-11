package task1.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task0.solutions.BinarySearchTree;
import task0.solutions.Node;
import task1.solutions.BST;

public class BSTTests {
	static Node root, child1, child2, child3, child4, child5;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		root = new Node(19);
		child1 = new Node(12);
		child2 = new Node(25);
		child3 = new Node(17);
		child4 = new Node(4);
		child5 = new Node(22);
		
		child1.setLeft(child4);
		child1.setRight(child3);
		child2.setLeft(child5);
		root.setLeft(child1);
		root.setRight(child2);
		
	}

	@Test
	public void test() {
		assertTrue(BST.isBST(root));
	}

}
