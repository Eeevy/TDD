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
		clockInstance.changeMode();
		clockInstance.reset();
	}
	
	/**
	 * S4 --> S2 - DateSet high BVA should return expected 
	 */
	@Test
	public void testSetDateOddMonthHighBVA1() {
		assertEquals("2100-12-30", clockInstance.set(2100, 12, 30));

	}

	/**
	 * S4 --> S2 - DateSet high BVA should return expected
	 */
	@Test
	public void testSetDateOddMonthHighBVA2() {
		assertEquals("2100-12-31", clockInstance.set(2100, 12, 31));

	}

	/**
	 * S4 --> S2 - DateSet odd month high BVA should return null (year above)
	 */
	@Test
	public void testSetDateOddMonthHighBVA3BAD() {
		assertNull(clockInstance.set(2101, 12, 31));

	}
	
	/**
	 * S4 --> S2 - DateSet odd month high BVA should return null (month above)
	 */
	@Test
	public void testSetDateOddMonthHighBVA4BAD() {
		assertNull(clockInstance.set(2100, 13, 31));

	}
	
	/**
	 * S4 --> S2 - DateSet odd month high BVA should return null (day above)
	 */
	@Test
	public void testSetDateOddMonthHighBVA5BAD() {
		assertNull(clockInstance.set(2100, 12, 32));

	}

	
	 // Following operations tests EVEN months; apr, jun, sept, nov
	
	/**
	 * S4 --> S2 - DateSet even month high BVA should return expected
	 */
	@Test
	public void testSetDateEvenMonthHighBVA1() {
		assertEquals("2100-06-29", clockInstance.set(2100, 6, 29));
	}

	/**
	 * S4 --> S2 - DateSet even month high BVA should return expected
	 */
	@Test
	public void testSetDateEvenMonthHighBVA2() {
		assertEquals("2100-06-30", clockInstance.set(2100, 6, 30));

	}

	/**
	 * S4 --> S2 - DateSet even month high BVA should return null (year above)
	 */
	@Test
	public void testSetDateEvenMonthHighBVA3BAD() {
		assertNull(clockInstance.set(2101, 6, 30));

	}
	
	/**
	 * S4 --> S2 - DateSet even month high BVA should return null (month above)
	 */
	@Test
	public void testSetDateEvenMonthHighBVA4BAD() {
		assertNull(clockInstance.set(2100, 13, 30));

	}
	
	/**
	 * S4 --> S2 - DateSet even month high BVA should return null (day above)
	 */
	@Test
	public void testSetDateEvenMonthHighBVA5BAD() {
		assertNull(clockInstance.set(2100, 6, 31));

	}

	// Following operations tests low borders Odd+even months

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return expected
	 */
	@Test
	public void testSetDateLowBVA1() {
		String expected = "2001-03-02";
		assertEquals(expected, clockInstance.set(2001, 03, 02));

	}

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return expected
	 */
	@Test
	public void testSetDateLowBVA2() {
		String expected = "2000-01-01";
		assertEquals(expected, clockInstance.set(2000, 01, 01));

	}

	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return NULL (year below)
	 */
	@Test
	public void testSetDateMonthLowBVA3BAD() {
		assertNull(clockInstance.set(1999, 01, 01));

	}
	
	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return NULL (month below)
	 */
	@Test
	public void testSetDateMonthLowBVA4BAD() {
		assertNull(clockInstance.set(2000, 00, 01));

	}
	
	/**
	 * S4 --> S2 - DateSet even+odd month low BVA should return NULL (day below)
	 */
	@Test
	public void testSetDateMonthLowBVA5BAD() {
		assertNull(clockInstance.set(2000, 01, 00));

	}

	
	 // Following operations test february inputs
	
	 /**
	  *  S4 --> S2 - DateSet february month high BVA should return expected
	  */
	@Test
	public void testSetDateFebruaryBVA1() {
		String expected = "2099-11-28";
		assertEquals(expected, clockInstance.set(2099, 11, 28));

	}

	
	 /**
	  *  S4 --> S2 - DateSet february month high BVA (leap year) should return expected
	  */
	@Test
	public void testSetDateFebruaryBVA2() {
		String expected = "2099-02-29";
		assertEquals(expected, clockInstance.set(2099, 2, 29));

	}

	
	 /**
	  * S4 --> S2 - DateSet february month high BVA should return NULL (day above)
	  */
	@Test
	public void testSetDateFebruaryLowBVA3() {
		assertNull(clockInstance.set(2100, 2, 30));

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
