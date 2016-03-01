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

	@Test
	public void testChangeModeTime() {
		String expectedState = "15:15:22";
		assertEquals(expectedState, clockInstance.changeMode());

	}

	@Test
	public void testResetAlterTime() {
		String expected = "Alter Time";
		assertEquals(expected, clockInstance.reset());

	}

	@Test
	public void testTimeSet() {
		String expected = "15:15:22";
		assertEquals(expected, clockInstance.set(15, 15, 22));
	}

	@Test
	public void testResetAlterDate() {
		String expected = "Alter Date";
		assertEquals(expected, clockInstance.reset());
	}

	@Test
	public void testDateSet() {
		String expected = "2016-03-01";
		assertEquals(expected, clockInstance.set(2016, 03, 01));
	}

	@Test
	public void testTimeHighBVA1() {
		String expected = "23:58:58";
		assertEquals(expected, clockInstance.set(23, 58, 58));
	}

	@Test
	public void testTimeHighBVA2() {
		String expected = "24:59:59";
		assertEquals(expected, clockInstance.set(24, 59, 59));
	}

	// Fail!
	@Test
	public void testTimeHighBVA3() {
		assertNull(null, clockInstance.set(25, 60, 60));
	}

	@Test
	public void testTimeLowBVA1() {
		String expected = "02:01:01";
		assertEquals(expected, clockInstance.set(02, 01, 01));
	}

	@Test
	public void testTimeLowBVA2() {
		String expected = "01:00:00";
		assertEquals(expected, clockInstance.set(01, 00, 00));
	}

	@Test
	public void testTimeLowBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(00, -1, -1));
	}

	// Following testMethods tests ODD months; jan, mar, may, july, aug, oct, dec

	@Test
	public void testDateEvevnMonthHighBVA1() {
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
	public void testDateLowBVA1() {
		String expected = "2001-01-01";
		assertEquals(expected, clockInstance.set(2001, 02, 02));
	}

	@Test
	public void testDateLowBVA2() {
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));

	}

	// Fail
	@Test
	public void testDateMonthLowBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(1999, 00, 00));
	}

	// Following methods test february inputs
	@Test
	public void testDateFebruaryBVA1() {
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));

	}

	@Test
	public void testDateFebruaryBVA2() {
		String expected = "2099-12-29";
		assertEquals(expected, clockInstance.set(2099, 12, 29));

	}

	// Fail
	@Test
	public void testDateFebruaryLowBVA3() {
		String expected = null;
		assertNull(expected, clockInstance.set(2101, 13, 30));
	}

	@Before
	public static void setUp() throws Exception {
		
	}

}