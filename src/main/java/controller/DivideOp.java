package controller;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.text.Position.Bias;

import exceptions.WrongDivisionFormatException;
import model.BiResult;
import model.Monomial;
import model.Polynomial;

public class DivideOp extends Operation <BiResult> {

	public DivideOp() {
		
	}
	
	@Override
	public BiResult calculate(Polynomial divisor, Polynomial dividend) {
		
		dividend = dividend.getDescSortedPolynomial();
		divisor = divisor.getDescSortedPolynomial();
		//TO DO: handle wrong format exception 
		
		Polynomial rem = new Polynomial();
		ArrayList<Monomial> d =  new ArrayList<Monomial>();
		Polynomial quot = new Polynomial();
		
		
		d.add(divisor.getPolynomial().get(0).divMonome(dividend.getPolynomial().get(0)));		
		quot.getPolynomial().add(d.get(0));
		rem.copyFromPoly( new MultiplyOp().calculate(dividend,quot));

		while(rem.getPolynomial().get(0).getExponent() > dividend.getPolynomial().get(0).getExponent() ) {
		 	
			// 2. subtract rem from divisor -->  result in rem
			rem.copyFromPoly(new SubtractOp().calculate(divisor, rem));
			divisor.copyFromPoly(rem);
			
			// 3. divide rem(0) by dvd(0) and add it to quotient
			d.set(0 ,rem.getPolynomial().get(0).divMonome(dividend.getPolynomial().get(0)));
			quot.getPolynomial().add(d.get(0));
			
			// 1. multiply dividend with quotient -->result in rem
			rem.copyFromPoly(new MultiplyOp().calculate(dividend, new Polynomial(d)));
			
			
		}
		//rem - divisor
		rem.copyFromPoly(new SubtractOp().calculate(rem, divisor));
		
		BiResult res = new BiResult(quot,rem);
		return res;
	}

	@Override
	public BiResult calculateOne(Polynomial p1) {
		// TODO Auto-generated method stub
		return null;
	}

}
