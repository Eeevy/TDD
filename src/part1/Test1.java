package part1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class Test1 {
	
	
	@Test
	public void testLowercaseLetters() {
		rovar testClass = new rovar();

		String input = "abcdefghijklmnopqrstuvxyzåäö";
		String expected = "abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovxoxyzozåäö";
		assertEquals(expected, rovar.enrov(input));
	}
	
	public void testUppercaseLetters() {
		String input = "ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ";
		String expected = "ABoBCoCDoDEFoFGoGHoHIJoJKoKLoLMoMNoNOPoPQoQRoRSoSToTUVoVXoXYZoZÅÄÖ";
		assertEquals(expected, rovar.enrov(input));
	}
	
//	@Test
//	public void test() {
//		rovar testClass = new rovar();
//		rovar.enrov("abcdefghijklmnopqrstuvxyzåäö");
//		rovar.enrov("åäö");
//		rovar.enrov("ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ");
//		rovar.enrov("00001237");
//		rovar.enrov("5");
//		rovar.enrov("");
//		rovar.enrov(null);
//		rovar.enrov("a77e666heJsaN");
//		rovar.enrov("007HAHA");
//		rovar.enrov("estar \n"
//				+ "att skriva fler rader \n"
//				+ "här");
//		rovar.enrov("en rad");
//		rovar.enrov("g");
//		rovar.enrov("giltigt input");
//		rovar.enrov("!”#°€%&/()=?`^^_.,<>");
//
//		rovar.derov("abcdefghijklmnopqrstuvxyzåäö");
//		rovar.derov("åäö");
//		rovar.derov("ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ");
//		rovar.derov("00001237");
//		rovar.derov("5");
//		rovar.derov("");
//		rovar.derov(null);
//		rovar.derov("a77e666heJsaN");
//		rovar.derov("007HAHA");
//		rovar.derov("estar \n"
//				+ "att skriva fler rader \n"
//				+ "här");
//		rovar.derov("en rad");
//		rovar.derov("g");
//		rovar.derov("giltigt input");
//		rovar.derov("!”#°€%&/()=?`^^_.,<>");
//	}
}