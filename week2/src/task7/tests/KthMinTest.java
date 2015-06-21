package task7.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import task7.solutions.KMin;

public class KthMinTest {
	static List<Integer> list = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(1);
		list.add(1);
		list.add(4);
	}

	@Test
	public void test() {
		assertEquals(1, KMin.kthMinimum(list, 1));
		assertEquals(3, KMin.kthMinimum(list, 3));
		assertEquals(6, KMin.kthMinimum(list, 6));
	}

}
