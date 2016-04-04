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

	}
	
	/**
	 * S3 --> S1 - TimeSet high BVA should return expected
	 */
	@Test
	public void testSetTimeHighBVA1() {
		clockInstance.reset();
		assertEquals("23:58:58", clockInstance.set(23, 58, 58));

	}

	/**
	 * S3 --> S1 - TimeSet high BVA should return expected
	 */
	@Test
	public void testSetTimeHighBVA2() {
		clockInstance.reset();
		assertEquals("24:59:59", clockInstance.set(24, 59, 59));

	}

	/**
	 * S3 --> S1 - TimeSet high BVA should return null
	 */
	@Test
	public void testSetTimeHighBVA3BAD() {
		clockInstance.reset();
		assertNull(clockInstance.set(25, 60, 60));
		// assertNotSame("25:60:60", clockInstance.set(25, 60, 60)); //Good as
		// well
	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return expected
	 */
	@Test
	public void testSetTimeLowBVA1() {
		clockInstance.reset();
		assertEquals("02:01:01", clockInstance.set(2, 1, 1));

	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return expected
	 */
	@Test
	public void testSetTimeLowBVA2() {
		clockInstance.reset();
		assertEquals("01:01:01", clockInstance.set(1, 1, 1));

	}

	/**
	 * S3 --> S1 - TimeSet low BVA should return null
	 */
	@Test
	public void testSetTimeLowBVA3BAD() {
		clockInstance.reset();
		assertNull(clockInstance.set(00, -1, -1));

	}

	
	@After
	public void tearDown() {
		clockInstance = null;
	}

}
