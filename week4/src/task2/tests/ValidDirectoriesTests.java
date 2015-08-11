package task2.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import task2.solutions.ValidDirecories;

public class ValidDirectoriesTests {
	static ValidDirecories validDir;
	static int[][] directories;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		directories = new int[][]{{0, 1, 0, 1, 0, 2},
								{0, 0, 2, 0, 0, 0},
								{0, 0, 0, 0, 0, 0},
								{1, 0, 0, 0, 2, 0},
								{0, 0, 0, 0, 0, 0},
								{0, 0, 0, 0, 0, 0}};
		
		int length = directories[0].length;
		
		validDir = new ValidDirecories(length);
	}

	@Test
	public void test() {
		assertTrue(!validDir.validateDirectories(directories, 0));
	}

}
