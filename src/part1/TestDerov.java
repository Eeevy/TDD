package part1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDerov {
	private static Rovar testClass;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testClass = new Rovar();
	}

	@Test
	public void testLowercaseLetters() {
		String input = "abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovxoxyzozåäö";
		String expected = "abcdefghijklmnopqrstuvxyzåäö";
		assertEquals(expected, testClass.derov(input));
	}

	@Test
	public void testUppercaseLetters() {
		String input = "ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVXOXYZOZÅÄÖ";
		String expected = "ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ";
		assertEquals(expected, testClass.derov(input));
	}
	
	@Test
	public void testStrangeLetters() {
		String input = "zozåäö";
		String expected = "zåäö";
		assertEquals(expected, testClass.derov(input));
	}
	
	@Test
	public void testNumbers() {
		String input = "00001237";
		String expected = "00001237";
		assertEquals(expected, testClass.derov(input));
	}

	@Test
	public void testNumber() {
		String input = "5";
		String expected = "5";
		assertEquals(expected, testClass.derov(input));
	}

	@Test
	public void testEmptyString() {
		String input = "";
		String expected = "";
		assertEquals(expected, testClass.derov(input));
	}

	@Test
	public void testNull() {
		String input = null;
		String expected = null;
		assertNull(expected, testClass.derov(input));
	}

	@Test
	public void testMixed() {
		String input = "a77e666hoheJOJsosaNON";
		String expected = "a77e666heJsaN";
		assertEquals(expected, testClass.derov(input));
	}
	
	@Test
	public void testMixedAllChars() {
		String input = "007HOHahohA*!";
		String expected = "007HahA*!";
		assertEquals(expected, testClass.derov(input));
	}
	
	@Test
	public void testOneChar() {
		String input = "gog";
		String expected = "g";
		assertEquals(expected, testClass.derov(input));
	}
	
	@Test
	public void testSymbol() {
		String input = "!”#°€%&/()=?`^^_.,<>";
		String expected = "!”#°€%&/()=?`^^_.,<>";
		assertEquals(expected, testClass.derov(input));
	}
}
