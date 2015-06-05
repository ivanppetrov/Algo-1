package brackets.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import brackets.solution.Brackets;

public class Tests {
	@Test
	public void test() {
		assertEquals("1870", Brackets.calculate("{123[123(123)123(123)]23[123]2}"));
		assertEquals("1337", Brackets.calculate("[123(145)38(37)812]"));
		assertEquals("264", Brackets.calculate("{125[2][(1)][3]125}"));
		assertEquals("500", Brackets.calculate("[125()125()125()125]"));
		assertEquals("NO", Brackets.calculate("{125()125}"));
		assertEquals("NO", Brackets.calculate("{125[12]{125}[12]125}"));
		assertEquals("NO", Brackets.calculate("{125[12(123]125}"));
	}
}
