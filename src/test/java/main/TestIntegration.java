package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Extractor;
import controller.Operation;
import exceptions.WrongDivisionFormatException;
import model.Polynomial;

public class TestIntegration {
	@Test
	public void test() throws WrongDivisionFormatException  {
		String p1 = "3x^4-3x^1+3x^0";
		Polynomial pol1 = Extractor.extractPolyFromString(p1);		
		Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Integrate");
		Polynomial rez = op.calculateOne(pol1 );
		String res =Extractor.polyToString(rez);
		assertEquals("+0.6x^5-1.5x^2+3x^1", res);
	
	}
}