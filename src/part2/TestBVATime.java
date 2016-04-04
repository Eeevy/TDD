package part2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBVATime {
	private Clock clockInstance;

	@Before
	public void setUpBeforeClass() throws Exception {
		clockInstance = new Clock();
		clockInstance.reset();
	}
	
	/**
	 * S3 --> S1 - TimeSet high BVA should return expected (below border)
	 */
	@Test
	public void testSetTimeHighBVA1() {
		assertEquals("23:59:59", clockInstance.set(23, 59, 59));

	}

	/**
	 * S3 --> S1 - TimeSet high BVA should return expected (on border)
	 */
	@Test
	public void testSetTimeHighBVA2() {
		assertEquals("24:00:00", clockInstance.set(24, 00, 00));

	}

	/**
	 * S3 --> S1 - TimeSet high BVA should return null (hour above)
	 */
	@Test
	public void testSetTimeHighBVA3BAD() {
		assertNull(clockInstance.set(25, 59, 59));
	}
	
	/**
	 * S3 --> S1 - TimeSet high BVA should return null (minute above)
	 */
	@Test
	public void testSetTimeHighBVA4BAD() {
		assertNull(clockInstance.set(22, 60, 25));
	}
	
	/**
	 * S3 --> S1 - TimeSet high BVA should return null (second above)
	 */
	@Test
	public void testSetTimeHighBVA5BAD() {
		assertNull(clockInstance.set(22, 23, 60));
	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return expected 
	 */
	@Test
	public void testSetTimeLowBVA1() {
		assertEquals("02:01:01", clockInstance.set(2, 1, 1));

	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return expected
	 */
	@Test
	public void testSetTimeLowBVA2() {
		assertEquals("01:01:01", clockInstance.set(1, 1, 1));

	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return null (hour above)
	 */
	@Test
	public void testSetTimeLowBVA3BAD() {
		assertNull(clockInstance.set(25, 0, 0));

	}
	
	/**
	 * S3 --> S1 - TimeSet low BVA should return null (minute above)
	 */
	@Test
	public void testSetTimeLowBVA4BAD() {
		assertNull(clockInstance.set(22, 60, 23));

	}
	
	/**
	 * S3 --> S1 - TimeSet low BVA should return null (second above)
	 */
	@Test
	public void testSetTimeLowBVA5BAD() {
		assertNull(clockInstance.set(22, 45, 60));

	}

	
	@After
	public void tearDown() {
		clockInstance = null;
	}

}
