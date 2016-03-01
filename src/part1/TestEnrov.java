package part1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEnrov {
	private static Rovar testClass;

	@BeforeClass
	public static void beforeTests() throws Exception {
		testClass = new Rovar();

	}

	@Test
	public void testLowercaseLetters() {
		String input = "abcdefghijklmnopqrstuvxyz";
		String expected = "abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovxoxyzoz";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testUppercaseLetters() {
		String input = "ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ";
		String expected = "ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVXOXYZOZÅÄÖ";
	}

	@Test
	public void testStrangeLetters() {
		String input = "zåäö";
		String expected = "zozåäö";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testNumbers() {
		String input = "00001237";
		String expected = "00001237";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testNumber() {
		String input = "5";
		String expected = "5";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testEmptyString() {
		String input = "";
		String expected = "";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testNull() {
		String input = null;
		String expected = "";
//		assertEquals(expected, testClass.enrov(input));
		assertNull(null, testClass.enrov(input));
	}

	@Test
	public void testMixed() {
		String input = "a77e666heJsaN";
		String expected = "a77e666hoheJOJsosaNON";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testMixedAllChars() {
		String input = "007HahA*!";
		String expected = "007HOHahohA*!";
		assertEquals(expected, testClass.enrov(input));
	}


	@Test
	public void testOneChar() {
		String input = "g";
		String expected = "gog";
		assertEquals(expected, testClass.enrov(input));
	}

	@Test
	public void testSymbols() {
		String input = "!”#°€%&/()=?`^^_.,<>";
		String expected = "!”#°€%&/()=?`^^_.,<>";
		assertEquals(expected, testClass.enrov(input));
	}

}