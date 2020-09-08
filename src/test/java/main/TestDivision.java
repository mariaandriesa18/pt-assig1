package main;

import controller.Extractor;
import controller.Operation;
import exceptions.WrongDivisionFormatException;
import model.BiResult;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import controller.Extractor;
import controller.Operation;
import model.Polynomial;



public class TestDivision {
	@Test
	public void test() throws WrongDivisionFormatException  {
		String p1 = "35x^4+3x^1+3x^0";
		String p2 = "1x^4-9x^1-1x^0";
		Polynomial pol1 = Extractor.extractPolyFromString(p1);
		Polynomial pol2 = Extractor.extractPolyFromString(p2);		
		Operation<BiResult> op = (Operation<BiResult>) Operation.getInstance("Divide");
		BiResult rez = op.calculate(pol1, pol2);
		String res = "quot: " + Extractor.polyToString(rez.getQuot()) +" rem: " + Extractor.polyToString(rez.getRem());
		assertEquals("quot: +35x^0 rem: -318x^1-38x^0", res);
	
	
}
}