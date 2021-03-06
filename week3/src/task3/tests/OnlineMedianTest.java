package task3.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import task3.OnlineMedian;

public class OnlineMedianTest {
	static int[] array, array2;
	static int size;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		size = 11;
		array = new int[size];
		array2 = new int[size];
		Random rd = new Random();
		for (int i = 0; i < size; i++) {
			int elem = rd.nextInt(20);
			array2[i] = elem;
			array[i] = Integer.MAX_VALUE;
		}
		
		
	}

	@Test
	public void test() {
		for (int i = 0; i < size; i++) {
			double index = Math.ceil((double)i /2);
			
			array[i] = array2[i];
			Arrays.sort(array);
			assertEquals(array[(int) index], OnlineMedian.getMedian(array2[i]));
//			System.out.println(index + " " + array[(int) index] + " " + OnlineMedian.getMedian(array2[i]));
		}
	}

}
