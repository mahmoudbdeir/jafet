package cmps252.oopreview.unitTesting;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

import cmps252.oopreview.FulltimeStudent;
import org.junit.Test;

public class Misc {

	@Test
	public void test() {
		try {
			var fts = new FulltimeStudent("", "Smith");
		} catch (Exception ex) {
			return;
		}
		fail("No exception was generated, that is an error, one should have been generated");
	}

	
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		var fts = new FulltimeStudent("", "Smith");
	}

	@Test
	public void foo() {

	}

}
