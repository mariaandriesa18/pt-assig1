package main;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import controller.Extractor;
import controller.Operation;
import exceptions.WrongDivisionFormatException;
import model.Polynomial;

public class TestMultiplication {
	@Test
	public void test() throws WrongDivisionFormatException  {
		String p1 = "10x^4+3x^1+1x^0";
		String p2 = "1x^4-9x^1-1x^0";
		Polynomial pol1 = Extractor.extractPolyFromString(p1);
		Polynomial pol2 = Extractor.extractPolyFromString(p2);
		Operation<Polynomial> instance = (Operation<Polynomial>) Operation.getInstance("Multiply");
		Operation<Polynomial> op = instance;
		Polynomial rez = new Polynomial();
		rez = op.calculate(pol1, pol2);
		String res =Extractor.polyToString(rez);
		assertEquals("+10x^8-87x^5-9x^4-27x^2-12x^1-1x^0", res);
	}
}