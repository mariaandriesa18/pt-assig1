package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.Monomial;
import model.Polynomial;

public class MultiplyOp extends Operation<Polynomial> {
	
	
	
	public MultiplyOp() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Polynomial calculate(Polynomial p1, Polynomial p2) {
		
		ArrayList<Monomial>res = new ArrayList<Monomial>(); 
		Monomial mul = new Monomial();
		
		for(Monomial m1 :p1.getPolynomial()) {
			
			for(Monomial m2 : p2.getPolynomial()) {
				boolean is = false;
				mul = new Monomial(m1.multMonome(m2).getCoefficient(),m1.multMonome(m2).getExponent()) ;
				
				if(res.size() > 1) {		
					for(int i = 0; i < res.size(); i++) {
							if(res.get(i).getExponent() == mul.getExponent()) {
								res.get(i).setCoefficient(res.get(i).getCoefficient().add(mul.getCoefficient()));
								is = true;
							}	 
						}
					}
				if(is == false) {
					res.add(mul); 
				}
			}
		}
	
		return new Polynomial(res).getDescSortedPolynomial();
		
	}
	@Override
	public Polynomial calculateOne(Polynomial p1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
