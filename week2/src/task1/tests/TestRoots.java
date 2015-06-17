package task1.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task1.solutions.Roots;

public class TestRoots {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(Roots.squareRoot(25));
	}

}
