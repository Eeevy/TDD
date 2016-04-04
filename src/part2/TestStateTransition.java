package part2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/** 
* S1 = DisplayTime 
* S2 = Display Date 
* S3 = Change Time 
* S4 = Change Date
* 
* CM = Change Mode 
* R = Reset 
* S = Set
* 
* ----------CM-----R------S--- 
* S1-------S2/D--S3/AT--S1/N--
* S2-------S1/T--S4/AD--S2/N-- 
* S3-------S3/N--S3/N---S1/T--
* S4-------S4/N--S4/N---S2/D--
* 
* @author emmashakespeare & Evelyn Gustavsson
*
*/
public class TestStateTransition {
	private Clock clockInstance;

	@Before
	public void setUpBeforeClass() throws Exception {
		clockInstance = new Clock();

	}

	@Test
	/**Change mode from S1 should --> S2 and return current date
	 * S1 --> S2.
	 */
	public void testChangeModeTimeToDate() {
		assertEquals("2000-01-01", clockInstance.changeMode());
	}

	@Test
	/**
	 * ChangeMode from S2 should --> S1 and return current time
	 */
	public void testChangeModeDateToTime() {
		clockInstance.changeMode();
		assertEquals("00:00:00", clockInstance.changeMode());
	}

	@Test
	/**
	 * Reset from S1 should --> S3 and return "Alter Time"
	 */
	public void testResetAlterTimeS1ToS3() {
		assertEquals("Alter Time", clockInstance.reset());
	}

	@Test
	/**
	 * Reset from S3 should --> fail
	 */
	public void testResetS3FAIL() {
		clockInstance.reset();
		assertNull(clockInstance.reset());
	}

	@Test
	/**
	 * Set from S1 should return null
	 */
	public void testSetS1FAIL() {
		assertNull(clockInstance.set(12, 12, 12));
	}

	@Test
	/**
	 * Reset from S2 should --> S4 and return Alter Date
	 */
	public void testResetAlterDateS2ToS4() {
		clockInstance.changeMode();
		assertEquals("Alter Date", clockInstance.reset());
	}

	@Test
	/**
	 * Reset from S4 should return null
	 */
	public void testResetS4FAIL() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.reset());

	}

	@Test
	/**
	 * Set from S2 should return null
	 */
	public void testSetS2FAIL() {
		clockInstance.changeMode();
		assertNull(clockInstance.set(12, 12, 12));
	}

	@Test
	/**
	 * TimeSet from S3 should --> S1 and return current time
	 */
	public void testSetS3ToS1() {
		clockInstance.reset();
		assertEquals("12:12:12", clockInstance.set(12, 12, 12));
	}

	@Test
	/**
	 * Change Mode from S3 should return null
	 */
	public void testChangeModeS3FAIL() {
		clockInstance.reset();
		assertNull(clockInstance.changeMode());
	}

	@Test
	/**
	 * DateSet from S4 should --> S2 and return current date
	 */
	public void setS4ToS2() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertEquals("2011-06-01", clockInstance.set(2011, 06, 01));
	}

	@Test
	/**
	 * Reset from S3 should return null
	 */
	public void resetS3FAIL() {
		clockInstance.reset();
		assertNull(clockInstance.reset());
	}

	@Test
	/**
	 * ChangeMode from S4 should return null
	 */
	public void changeModeS4FAIL() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.changeMode());
	}

	@Test
	/**
	 * Reset from S4 should return null
	 */
	public void resetS4FAIL() {
		clockInstance.changeMode();
		clockInstance.reset();
		assertNull(clockInstance.reset());
	}

	@After
	public void tearDown() {
		clockInstance = null;
	}

}
