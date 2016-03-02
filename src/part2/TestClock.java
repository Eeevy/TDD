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
	public void testChangeModeDate() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expectedState = "2016-03-01";
			assertEquals(expectedState, clockInstance.changeMode());
			// State = SHOWDATE
		}
	}

	@Test
	public void testChangeModeTime() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expectedState = "15:15:22";
			assertEquals(expectedState, clockInstance.changeMode());
			// State = SHOWTIME
		}
	}

	@Test
	public void testResetAlterTime() {
		if (clockInstance.getCurrentState() == State.SHOWTIME) {
			String expected = "Alter Time";
			assertEquals(expected, clockInstance.reset());
			// State = CHANGETIME
		}
	}

	@Test
	public void testTimeSet() {
		if (clockInstance.getCurrentState() == State.CHANGETIME) {
			String expected = "15:15:22";
			assertEquals(expected, clockInstance.set(15, 15, 22));
			// State = SHOWTIME
		}
	}

	@Test
	public void testResetAlterDate() {
		if (clockInstance.getCurrentState() == State.SHOWDATE) {
			String expected = "Alter Date";
			assertEquals(expected, clockInstance.reset());
			// State = CHANGEDATE
		}
	}

	@Test
	public void testDateSet() {
		if (clockInstance.getCurrentState() == State.CHANGEDATE) {
			String expected = "2016-03-01";
			assertEquals(expected, clockInstance.set(2016, 03, 01));
			// State = SHOWDATE
		}
	}

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
		// State = CHANGETIME
		}
	}

	// Following testMethods tests ODD months; jan, mar, may, july, aug, oct,
	// dec

	@Test
	public void testDateOddMonthHighBVA1() {
		String expected = "2100-12-30";
		assertEquals(expected, clockInstance.set(2100, 12, 30));
	}

	@Test
	public void testDateOddMonthHighBVA2() {
		String expected = "2100-12-31";
		assertEquals(expected, clockInstance.set(2100, 12, 31));
	}

	// Fail
	@Test
	public void testDateOddMonthHighBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(2101, 13, 32));
	}

	// Following testMethods tests EVEN months; apr, jun, sept, nov

	@Test
	public void testDateEvenMonthHighBVA1() {
		String expected = "2100-12-29";
		assertEquals(expected, clockInstance.set(2100, 12, 29));
	}

	@Test
	public void testDateEvenMonthHighBVA2() {
		String expected = "2100-12-30";
		assertEquals(expected, clockInstance.set(2100, 12, 30));
	}

	// Fail
	@Test
	public void testDateEvenMonthHighBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(2101, 13, 31));
	}

	// Following methods tests low borders Odd+even months

	@Test
	public void testSetDateLowBVA1() {
		String expected = "2001-01-01";
		assertEquals(expected, clockInstance.set(2001, 02, 02));
	}

	@Test
	public void testSetDateLowBVA2() {
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));

	}

	// Fail
	@Test
	public void testSetDateMonthLowBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(1999, 00, 00));
	}

	// Following methods test february inputs
	@Test
	public void testSetDateFebruaryBVA1() {
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));

	}

	@Test
	public void testSetDateFebruaryBVA2() {
		String expected = "2099-12-29";
		assertEquals(expected, clockInstance.set(2099, 12, 29));

	}

	// Fail
	@Test
	public void testSetDateFebruaryLowBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(2101, 13, 30));
	}

	@Before
	public static void setUp() throws Exception {

	}

}