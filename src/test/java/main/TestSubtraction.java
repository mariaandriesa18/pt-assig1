package main;
import static org.junit.Assert.*;

import org.junit.Test;
import controller.Extractor;
import controller.Operation;
import exceptions.WrongDivisionFormatException;
import model.Polynomial;

public class TestSubtraction {
	
	@Test
	public void test() throws WrongDivisionFormatException  {
		String p1 = "35x^4+3x^1+3x^0";
		String p2 = "1x^4-9x^1-1x^0";
		Polynomial pol1 = Extractor.extractPolyFromString(p1);
		Polynomial pol2 = Extractor.extractPolyFromString(p2);
		
		Operation<Polynomial> instance = (Operation<Polynomial>) Operation.getInstance("Subtract");
		Operation<Polynomial> op = instance;
		Polynomial rez = new Polynomial();
		rez = op.calculate(pol1, pol2);
		String res =Extractor.polyToString(rez);
		
		assertEquals("+34x^4+12x^1+4x^0", res);
		
	}
}
