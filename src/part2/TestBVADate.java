package part2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBVADate {

	private Clock clockInstance;

	@Before
	public void setUpBeforeClass() throws Exception {
		clockInstance = new Clock();

	}
	
	/**
	 * S4 --> S2 - DateSet high BVA should return expected
	 */
	@Test
	public void testSetDateOddMonthHighBVA1() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertEquals("2100-12-30", clockInstance.set(2100, 12, 30));

	}

	/**
	 * S4 --> S2 - DateSet high BVA should return expected
	 */
	@Test
	public void testSetDateOddMonthHighBVA2() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertEquals("2100-12-31", clockInstance.set(2100, 12, 31));

	}

	/**
	 * S4 --> S2 - DateSet odd month high BVA should return null
	 */
	@Test
	public void testSetDateOddMonthHighBVA3BAD() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.set(2101, 13, 32));

	}

	
	 // Following operations tests EVEN months; apr, jun, sept, nov
	
	/**
	 * S4 --> S2 - DateSet even month high BVA should return expected
	 */
	@Test
	public void testSetDateEvenMonthHighBVA1() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertEquals("2100-12-29", clockInstance.set(2100, 12, 29));
	}

	/**
	 * S4 --> S2 - DateSet even month high BVA should return expected
	 */
	@Test
	public void testSetDateEvenMonthHighBVA2() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertEquals("2100-12-30", clockInstance.set(2100, 12, 30));

	}

	/**
	 * S4 --> S2 - DateSet even month high BVA should return null
	 */
	@Test
	public void testSetDateEvenMonthHighBVA3BAD() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.set(2101, 13, 31));

	}

	// Following operations tests low borders Odd+even months

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return expected
	 */
	@Test
	public void testSetDateLowBVA1() {
		clockInstance.changeMode();
		clockInstance.reset();
		String expected = "2001-02-02";
		assertEquals(expected, clockInstance.set(2001, 02, 02));

	}

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return expected
	 */
	@Test
	public void testSetDateLowBVA2() {
		clockInstance.changeMode();
		clockInstance.reset();
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));

	}

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return NULL
	 */
	@Test
	public void testSetDateMonthLowBVA3BAD() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.set(1999, 00, 00));

	}

	
	 // Following operations test february inputs
	
	 /**
	  *  S4 --> S2 - DateSet february month high BVA should return expected
	  */
	@Test
	public void testSetDateFebruaryBVA1() {
		clockInstance.changeMode();
		clockInstance.reset();
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));

	}

	
	 /**
	  *  S4 --> S2 - DateSet february month high BVA (leap year) should return expected
	  */
	@Test
	public void testSetDateFebruaryBVA2() {
		clockInstance.changeMode();
		clockInstance.reset();
		String expected = "2099-12-29";
		assertEquals(expected, clockInstance.set(2099, 12, 29));

	}

	
	 /**
	  * S4 --> S2 - DateSet february month high BVA should return NULL
	  */
	@Test
	public void testSetDateFebruaryLowBVA3() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.set(2101, 13, 30));

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

	@After
	public void tearDown() {
		clockInstance = null;
	}
}
