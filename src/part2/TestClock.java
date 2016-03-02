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
	public void testChangeModeTimeToDate() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			clockInstance.changeMode();
			assertEquals(State.SHOWDATE, clockInstance.getCurrentState());
			// State = SHOWDATE
		}
	}

	@Test
	/**
	 * S2 --> S1.
	 */
	public void testChangeModeDateToTime() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			clockInstance.changeMode();
			assertEquals(State.SHOWTIME, clockInstance.getCurrentState());
			// State = SHOWTIME
		}
	}

	@Test
	/**
	 * S1 --> S3.
	 */
	public void testResetAlterTime() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			clockInstance.reset();
			assertEquals(State.CHANGETIME, clockInstance.getCurrentState());
			// State = CHANGETIME
		}
	}
	
	@Test
	/**
	 * S2 --> S4.
	 */
	public void testResetAlterDate() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			clockInstance.reset();
			assertEquals(State.CHANGEDATE, clockInstance.getCurrentState());
			// State = CHANGEDATE
		}
	}

	@Test
	/**
	 * S3 --> S1.
	 */
	public void testTimeSet() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			clockInstance.set(15, 15, 22);
			assertEquals(State.SHOWTIME, clockInstance.getCurrentState());
			// State = SHOWTIME
		}
	}

	

	@Test
	/**
	 * S4 --> S2.
	 */
	public void testDateSet() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			clockInstance.set(2000, 06, 24);
			assertEquals(State.SHOWDATE, clockInstance.getCurrentState());
			// State = SHOWDATE
		}
	}
	
	

	// Nedanstående testmetoder testar gränsvärden enligt Border Value Analysis.

	// Borde anropa reset-metoden istället om logiken ska bli rätt. Annars måste
	// det ändras så att det verkligen är SET istället. Jag har utgått från att
	// testmetoderna använder reset/alter time istället för set.

	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "23:58:58";
			assertEquals(expected, clockInstance.set(23, 58, 58));
			// State = SHOWTIME
		}
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "24:59:59";
			assertEquals(expected, clockInstance.set(24, 59, 59));
			// State = SHOWTIME
		}
	}

	// Fail!
	// S3 --> S1 - set
	@Test
	public void testSetTimeHighBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			assertNull(null, clockInstance.set(25, 60, 60));
			// State = CHANGETIME (OFÖRÄNDRAT)
		}
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "02:01:01";
			assertEquals(expected, clockInstance.set(02, 01, 01));
			// State = SHOWTIME
		}
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "01:00:00";
			assertEquals(expected, clockInstance.set(01, 00, 00));
			// State = SHOWTIME
		}
	}

	// S3 --> S1 - set
	@Test
	public void testSetTimeLowBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = null;
			assertNull(expected, clockInstance.set(00, -1, -1));
			// State = CHANGETIME (OFÖRÄNDRAT)
		}
	}

	// Following testMethods tests ODD months; jan, mar, may, july, aug, oct,
	// dec

	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2100-12-30";
			assertEquals(expected, clockInstance.set(2100, 12, 30));
			// State = SHOWDATE
		}
	}
	
	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2100-12-31";
			assertEquals(expected, clockInstance.set(2100, 12, 31));
			// State = SHOWDATE
		}
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateOddMonthHighBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(2101, 13, 32));
			// State = CHANGEDATE (OFÖRÄNDRAT)
		}
	}

	// Following testMethods tests EVEN months; apr, jun, sept, nov

	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2100-12-29";
			assertEquals(expected, clockInstance.set(2100, 12, 29));
			// State = SHOWDATE
		}
	}
	
	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2100-12-30";
			assertEquals(expected, clockInstance.set(2100, 12, 30));
			// State = SHOWDATE
		}
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateEvenMonthHighBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(2101, 13, 31));
			// State = CHANGEDATE (OFÖRÄNDRAT)
		}
	}

	// Following methods tests low borders Odd+even months

	// S4 --> S2 - set
	@Test
	public void testSetDateLowBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2001-01-01";
			assertEquals(expected, clockInstance.set(2001, 02, 02));
			// State = SHOWDATE
		}
	}
	
	// S4 --> S2 - set
	@Test
	public void testSetDateLowBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2000-01-01";
			assertEquals(expected, clockInstance.set(2000, 01, 01));
			// State = SHOWDATE
		}
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateMonthLowBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(1999, 00, 00));
			// State = CHANGEDATE (OFÖRÄNDRAT)
		}
	}

	// Following methods test february inputs

	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryBVA1() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2099-11-28";
			assertEquals(expected, clockInstance.set(2099, 11, 28));
			// State = SHOWDATE
		}
	}

	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryBVA2() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2099-12-29";
			assertEquals(expected, clockInstance.set(2099, 12, 29));
			// State = SHOWDATE
		}
	}

	// Fail
	// S4 --> S2 - set
	@Test
	public void testSetDateFebruaryLowBVA3() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = null;
			assertNull(expected, clockInstance.set(2101, 13, 30));
			// State = CHANGEDATE (OFÖRÄNDRAT)
		}
	}
	
	// TODO: Testmetod för default-values.

	@Before
	public static void setUp() throws Exception {

	}

}