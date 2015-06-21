package task3.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task3.solutions.Quadruplets;

public class QuadrupletsTest {
	static int[]a;
	static int[]b;
	static int[]c;
	static int[]d;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		a = new int[]{5, 3, 4};
		b = new int[]{-2, -1, 6};
		c = new int[]{-1, -2, 4};
		d = new int[]{-1, -2, 7};
	}

	@Test
	public void test() {
		assertEquals(7, Quadruplets.zeroQuadrupletsCount(a, b, c, d));
	}

}
