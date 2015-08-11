package task0.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task0.solutions.BinarySearchTree;

public class BSTTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(19);
		tree.insert(12);
		tree.insert(25);
		tree.insert(17);
		tree.insert(4);
		tree.insert(22);
		tree.insert(23);
		
		tree.traverse();
		
		tree.remove(19);
		System.out.println();
		tree.traverse();
	}

}
