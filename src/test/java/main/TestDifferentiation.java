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



public class TestDifferentiation {
	@Test
	public void test() throws WrongDivisionFormatException   {
		String p1 = "-3x^4+3x^1+3x^0";
		Polynomial pol1 = Extractor.extractPolyFromString(p1);		
		Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Derive");
		Polynomial rez = op.calculateOne(pol1 );
		String res =Extractor.polyToString(rez);
		assertEquals("-12x^3+3x^0", res);
	
	
}
}
