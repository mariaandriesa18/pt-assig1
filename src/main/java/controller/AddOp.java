package controller;
import model.Polynomial;
import model.Monomial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.Monomial;

public class AddOp extends Operation<Polynomial>{

	AddOp(){
		
	}
	
	@Override
	public Polynomial calculate(Polynomial p1, Polynomial p2) {
		
		Polynomial clone = new Polynomial();
		
			for (int j = 0; j < p1.getLen(); j++) {
				clone.getPolynomial().add(p1.getPolynomial().get(j));
			}
			
		 for (Monomial e2 : p2.getPolynomial()) {
				if (!clone.getPolynomial().contains(e2)){ 
					for( int i = 0; i < clone.getLen(); i++) { 
						//if exponents are equal
						if(e2.getExponent() == clone.getPolynomial().get(i).getExponent()) {
							clone.getPolynomial().get(i).setCoefficient(clone.getPolynomial().get(i).getCoefficient().add(e2.getCoefficient()));
							//remove from 2nd polynomial the added
						}
					}
				}
			
			}
	
		 
		 for(Monomial e2 : p2.getPolynomial()) {
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
