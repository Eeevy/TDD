package part2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClock {
	private static Clock clockInstance;
	private static State state;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		this.clockInstance = new Clock();
		// this.state = state; ?
	}

	@Test
	/**
	 * S1 --> S2.
	 */
	public void testChangeModeDate() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expectedState = "2016-03-01";
//			String expected = 
			assertEquals(expectedState, clockInstance.changeMode());
			// State = SHOWDATE
		}
	}

	@Test
	/**
	 * S2 --> S1.
	 */
	public void testChangeModeTime() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expectedState = "15:15:22";
			assertEquals(expectedState, clockInstance.changeMode());
			// State = SHOWTIME
		}
	}

	@Test
	/**
	 * S1 --> S3.
	 */
	public void testResetAlterTime() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "Alter Time";
			assertEquals(expected, clockInstance.reset());
			// State = CHANGETIME
		}
	}

	@Test
	/**
	 * S3 --> S1.
	 */
	public void testTimeSet() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "15:15:22";
			assertEquals(expected, clockInstance.set(15, 15, 22));
			// State = SHOWTIME
		}
	}

	@Test
	/**
	 * S2 --> S4.
	 */
	public void testResetAlterDate() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "Alter Date";
			assertEquals(expected, clockInstance.reset());
			// State = CHANGEDATE
		}
	}

	@Test
	/**
	 * S4 --> S2.
	 */
	public void testDateSet() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2016-03-01";
			assertEquals(expected, clockInstance.set(2016, 03, 01));
			// State = SHOWDATE
		}
	}
	
	// Nedanstående testmetoder testar gränsvärden enligt Border Value Analysis,

	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeHighBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "23:58:58";
			assertEquals(expected, clockInstance.set(23, 58, 58));
			// State = CHANGETIME
		}
	}

	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeHighBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "24:59:59";
			assertEquals(expected, clockInstance.set(24, 59, 59));
			// State = CHANGETIME
		}
	}

	// Fail!
	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeHighBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			assertNull(null, clockInstance.set(25, 60, 60));
			// State = CHANGETIME
		}
	}

	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeLowBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "02:01:01";
			assertEquals(expected, clockInstance.set(02, 01, 01));
			// State = CHANGETIME
		}
	}

	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeLowBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "01:00:00";
			assertEquals(expected, clockInstance.set(01, 00, 00));
			// State = CHANGETIME
		}
	}

	// S1 till S3 - Reset/Alter Time
	@Test
	public void testSetTimeLowBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = null;
			assertNull(expected, clockInstance.set(00, -1, -1));
			// State = SHOWTIME (OFÖRÄNDRAT)
		}
	}

	// Following testMethods tests ODD months; jan, mar, may, july, aug, oct,
	// dec

	@Test
	public void testSetDateOddMonthHighBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "2100-12-30";
			assertEquals(expected, clockInstance.set(2100, 12, 30));
			// State = CHANGEDATE
		}
	}

	@Test
	public void testSetDateOddMonthHighBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "2100-12-31";
			assertEquals(expected, clockInstance.set(2100, 12, 31));
			// State = CHANGEDATE
		}
	}

	// Fail
	@Test
	public void testSetDateOddMonthHighBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(2101, 13, 32));
			// State = SHOWDATE (OFÖRÄNDRAT)
		}
	}

	// Following testMethods tests EVEN months; apr, jun, sept, nov

	@Test
	public void testSetDateEvenMonthHighBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "2100-12-29";
			assertEquals(expected, clockInstance.set(2100, 12, 29));
			// State = CHANGEDATE
		}
	}

	@Test
	public void testSetDateEvenMonthHighBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "2100-12-30";
			assertEquals(expected, clockInstance.set(2100, 12, 30));
			// State = CHANGEDATE
		}
	}

	// Fail
	@Test
	public void testSetDateEvenMonthHighBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(2101, 13, 31));
			// State = SHOWDATE (OFÖRÄNDRAT)
		}
	}

	// Following methods tests low borders Odd+even months

	@Test
	public void testSetDateLowBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = "2001-01-01";
		assertEquals(expected, clockInstance.set(2001, 02, 02));
		// State = CHANGEDATE
		}
	}

	@Test
	public void testSetDateLowBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));
		// State = CHANGEDATE
		}
	}

	// Fail
	@Test
	public void testSetDateMonthLowBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = null;
		assertNull(expected, clockInstance.set(1999, 00, 00));
		}
	}

	// Following methods test february inputs
	@Test
	public void testSetDateFebruaryBVA1() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));
		// State = CHANGEDATE
		}
	}

	@Test
	public void testSetDateFebruaryBVA2() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = "2099-12-29";
		assertEquals(expected, clockInstance.set(2099, 12, 29));
		// State = CHANGEDATE
		}
	}

	// Fail
	@Test
	public void testSetDateFebruaryLowBVA3() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
		String expected = null;
		assertNull(expected, clockInstance.set(2101, 13, 30));
		// State = SHOWDATE (OFÖRÄNDRAT)
		}
	}

	/*
	 * LÄGG TILL FLER TESTMETODER SOM TESTAR CHANGEDATE --> SHOWDATE SAMT
	 * CHANGETIME --> SHOWTIME. ELLER?
	 */

	@Before
	public static void setUp() throws Exception {

	}

}