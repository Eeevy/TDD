package part2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestClock {
	private static Clock clockInstance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		clockInstance = new Clock();
	}

	@Test
	/**
	 * S1 --> S2.
	 */
	public void testChangeModeTimeToDate() {
		clockInstance.setState(State.SHOWTIME);
		clockInstance.changeMode();
		assertEquals(State.SHOWDATE, clockInstance.getCurrentState());
	}

	@Test
	/**
	 * S2 --> S1.
	 */
	public void testChangeModeDateToTime() {
		clockInstance.setState(State.SHOWDATE);
		clockInstance.changeMode();
		assertEquals(State.SHOWTIME, clockInstance.getCurrentState());
	
	}

	@Test
	/**
	 * S1 --> S3.
	 */
	public void testResetAlterTime() {
		clockInstance.setState(State.SHOWTIME);
		clockInstance.reset();
		assertEquals(State.CHANGETIME, clockInstance.getCurrentState());
	}

	@Test
	/**
	 * S2 --> S4.
	 */
	public void testResetAlterDate() {
		clockInstance.setState(State.SHOWDATE);
		clockInstance.reset();
		assertEquals(State.CHANGEDATE, clockInstance.getCurrentState());
		
	}

	@Test
	/**
	 * S3 --> S1.
	 */
	public void testTimeSet() {
		clockInstance.setState(State.CHANGETIME);
		clockInstance.set(15, 15, 22);
		assertEquals(State.SHOWTIME, clockInstance.getCurrentState());
		
	}

	@Test
	/**
	 * S4 --> S2.
	 */
	public void testDateSet() {
		clockInstance.setState(State.CHANGEDATE);

		clockInstance.set(2000, 06, 24);
		assertEquals(State.SHOWDATE, clockInstance.getCurrentState());
	}

	// Following operations test Time and Date objects according to BVA

	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA1() {
		clockInstance.setState(State.CHANGETIME);

		String expected = "23:58:58";
		assertEquals(expected, clockInstance.set(23, 58, 58));
		
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA2() {
		clockInstance.setState(State.CHANGETIME);

		String expected = "24:59:59";
		assertEquals(expected, clockInstance.set(24, 59, 59));
		
	}

	// Fail!
	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA3BAD() {
		clockInstance.setState(State.CHANGETIME);

		assertNotSame("25:60:60", clockInstance.set(25, 60, 60));
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA1() {
		clockInstance.setState(State.CHANGETIME);

		String expected = "02:01:01";
		assertEquals(expected, clockInstance.set(02, 01, 01));
		
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA2() {
		clockInstance.setState(State.CHANGETIME);

		String expected = "01:01:01";
		assertEquals(expected, clockInstance.set(01, 01, 01));
		
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA3() {
		clockInstance.setState(State.CHANGETIME);

		String expected = null;
		assertNull(expected, clockInstance.set(00, -1, -1));
		
	}

	// Following operations tests ODD months; jan, mar, may, july, aug, oct,
	// dec

	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA1() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2100-12-30";
		assertEquals(expected, clockInstance.set(2100, 12, 30));
		
	}

	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA2() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2100-12-31";
		assertEquals(expected, clockInstance.set(2100, 12, 31));
		
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA3BAD() {
		clockInstance.setState(State.CHANGEDATE);
		assertNotSame("2101-13-32", clockInstance.set(2101, 13, 32));
		
	}

	// Following operations tests EVEN months; apr, jun, sept, nov

	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA1() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2100-12-29";
		assertEquals(expected, clockInstance.set(2100, 12, 29));
	}

	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA2() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2100-12-30";
		assertEquals(expected, clockInstance.set(2100, 12, 30));
		
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA3() {
		String expected = null;
		assertNull("2101:13:31", clockInstance.set(2101, 13, 31));
		
	}

	// Following operations tests low borders Odd+even months

	// S4 --> S2 - set
	@Test
	public void testSetDateLowBVA1() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2001-02-02";
		assertEquals(expected, clockInstance.set(2001, 02, 02));
		
	}

	// S4 --> S2 - set
	@Test
	public void testSetDateLowBVA2() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));
		
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateMonthLowBVA3() {
		
		assertNotSame("1999-00-00", clockInstance.set(1999, 00, 00));
		
	}

	// Following operations test february inputs

	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryBVA1() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));
		
	}

	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryBVA2() {
		clockInstance.setState(State.CHANGEDATE);
		String expected = "2099-12-29";
		assertEquals(expected, clockInstance.set(2099, 12, 29));
		
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryLowBVA3() {
		clockInstance.setState(State.CHANGEDATE);
		assertNotSame("2101-13-30", clockInstance.set(2101, 13, 30));
		
	}

	/**
	 * Operation tests default values -Date
	 */
	@Test
	public void testDefaultDate() {
		Clock clockInstanceDefault1 = new Clock();
		assertEquals("2000-01-01", clockInstanceDefault1.changeMode());
	}

	/**
	 * Operation test default values - Time
	 */
	@Test
	public void testDefaultTime() {
		Clock clockInstanceDefault2 = new Clock();
		assertEquals("2000-01-01", clockInstanceDefault2.changeMode());
	}

}