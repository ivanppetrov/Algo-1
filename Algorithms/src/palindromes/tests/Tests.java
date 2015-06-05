package palindromes.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import palindromes.solution.Palindoromes;

public class Tests {

	@Test
	public void test() {
		assertEquals("NONE", Palindoromes.getAllPalindromes("shakira"));
		assertEquals("akawwaka\nwakaakaw\n", Palindoromes.getAllPalindromes("akawwaka"));
		assertEquals("NONE", Palindoromes.getAllPalindromes("shakira"));
	}

}
