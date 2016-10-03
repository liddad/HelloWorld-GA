package v1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TargerCreatorTest {

	@Test
	public void testBoth() {
		String s = "Hello World!";
		assertEquals(s, TargetCreator.readArray(TargetCreator.getBooleanArray(s)));
	}

}
