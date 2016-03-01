package part2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClock {
	private static Clock clockInstance;
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		this.clockInstance = new Clock();
	}
	
	@Test
	public void testChangeModeDate() {
		String expectedState = "2016-03-01";
		assertEquals(expectedState, clockInstance.changeMode());
	}
	
	public void testChangeModeTime() {
		String expectedState = "15:15:22";
		assertEquals(expectedState, clockInstance.changeMode());
		
	}
	
	public void testResetAlterTime() {
		String expected = "Alter Time";
		assertEquals(expected, clockInstance.reset());
		
	}
	
	public void testTimeSet() {
		String expected = "15:15:22";
		assertEquals(expected, clockInstance.reset());
	}
	
	public void testResetAlterDate() {
		String expected = "Alter Date";
		assertEquals(expected, clockInstance.reset());
	}
	
	public void testDateSet() {
		String expected = "2016-03-01";
		assertEquals(expected, clockInstance.reset());
	}
	
	@Before
	public static void setUp() throws Exception {
	}

	
}