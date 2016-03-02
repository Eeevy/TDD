package part2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClock {
	private static Clock clockInstance;
	private State state;
	
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
	public void testTimeHighBVA1(){
		String expected = "23:58:58";
		assertEquals(expected, clockInstance.set(23, 58, 58));
	}
	
	@Test
	public void testTimeHighBVA2(){
		String expected = "24:59:59";
		assertEquals(expected, clockInstance.set(24, 59, 59));
	}
	
	//Fail!
	@Test
	public void testTimeHighBVA3(){
		assertNull(null, clockInstance.set(25, 60, 60));
	}
	
	@Test
	public void testTimeLowBVA1(){
		String expected = "02:01:01";
		assertEquals(expected, clockInstance.set(02, 01, 01));
	}
	
	@Test
	public void testTimeLowBVA2(){
		String expected = "01:00:00";
		assertEquals(expected, clockInstance.set(01, 00, 00));
	}
	
	@Test
	public void testTimeLowBVA3(){
		String expected = null;
		assertNull(expected, clockInstance.set(00, -1, -1));
	}
	
	
	@Test
	public void testDateHighBVA1(){
		String expected = "23:58:58";
		assertEquals(expected, clockInstance.set(23, 58, 58));
	}
	
	@Test
	public void testDateHighBVA2(){
		String expected = "24:59:59";
		assertEquals(expected, clockInstance.set(24, 59, 59));
	}
	
	//Fail!
	@Test
	public void testDateHighBVA3(){
		assertNull(null, clockInstance.set(25, 60, 60));
	}
	
	@Test
	public void testDateLowBVA1(){
		String expected = "02:01:01";
		assertEquals(expected, clockInstance.set(02, 01, 01));
	}
	
	@Test
	public void testDateLowBVA2(){
		String expected = "01:00:00";
		assertEquals(expected, clockInstance.set(01, 00, 00));
	}
	
	@Test
	public void testDateLowBVA3(){
		String expected = null;
		assertNull(expected, clockInstance.set(00, -1, -1));
	
	}
	
	@Before
	public static void setUp() throws Exception {
	}

	
}