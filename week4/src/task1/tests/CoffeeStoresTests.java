package task1.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task1.solutions.ClosestCoffeeStore;

public class CoffeeStoresTests {
	static byte[][] graph;
	static byte[] coffeStore;
	static int startingPoint;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		graph = new byte[][]{{0, 1, 0, 1, 0, 0},
							{1, 0, 1, 0, 0, 0},
							{0, 1, 0, 0, 1, 0},
							{1, 0, 0, 0, 0, 0},
							{0, 0, 1, 0, 0, 1},
							{0, 0, 0, 0, 1, 0}};
		coffeStore = new byte[]{0, 0, 1, 0, 0, 1};
		startingPoint = 0;
	}

	@Test
	public void test() {
		assertEquals(2, ClosestCoffeeStore.closestCoffeeStore(graph, coffeStore, startingPoint));
	}

}
