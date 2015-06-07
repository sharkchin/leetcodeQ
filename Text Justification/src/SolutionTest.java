import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest {
	Solution s;
	String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
	int maxWidth = 16;
	@Before
	public void setUp() throws Exception {
		s = new Solution();		
	}

	@Test
	public void testFullJustify() {
		List<String> res = s.fullJustify(words, maxWidth);
		System.out.print(res);
	}

	@Test
	public void testJustifyRow() {
		String str = s.justifyRow(words, 0, 3, 10, 16);
		System.out.println(str);
	}

	@Test
	public void testJustifyLastRow() {
		String str = s.justifyLastRow(words, 6, 7);
		System.out.println(str);
	}

	@Test
	public void testSpaces() {
		String str = s.spaces(4);
		assertEquals(true, "    ".equals(str));
	}

}
