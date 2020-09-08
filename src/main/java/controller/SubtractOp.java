package controller;

import java.math.BigDecimal;

import model.Monomial;
import model.Polynomial;

public class SubtractOp extends Operation<Polynomial> {

	public SubtractOp() {
		
	}
	
	@Override
	public Polynomial calculate(Polynomial subtractor, Polynomial subtrahend) {
		
		Polynomial clone = new Polynomial();
		
			for (int j = 0; j < subtractor.getLen(); j++) {
				clone.getPolynomial().add(subtractor.getPolynomial().get(j));
			}
			
			
		 for (Monomial e2 : subtrahend.getPolynomial()) {
			 e2.setCoefficient(e2.getCoefficient().multiply(new BigDecimal(-1)));
				if (!clone.getPolynomial().contains(e2)){ 
					for( int i = 0; i < clone.getLen(); i++) { 
						//if exponents are equal
						if(e2.getExponent() == clone.getPolynomial().get(i).getExponent()) {
							clone.getPolynomial().get(i).setCoefficient(clone.getPolynomial().get(i).getCoefficient().add(e2.getCoefficient()));
							
						}
					}
				}
			
			}
	
		 
		 for(Monomial e2 : subtrahend.getPolynomial()) {
			 if(!clone.getArrayOfExp().contains(e2.getExponent())) {
				 clone.getPolynomial().add(e2);
			 }
		 }
		 
		 return clone.getDescSortedPolynomial();
		
	}

	@Override
	public Polynomial calculateOne(Polynomial p1) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
