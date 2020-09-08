package controller;

import model.Monomial;
import model.Polynomial;
import java.util.*;

public class DeriveOp extends Operation<Polynomial>{

	public DeriveOp() {
		
	}
	@Override
	public Polynomial calculate(Polynomial p1, Polynomial p2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial calculateOne(Polynomial p1) {
		
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		for(Monomial m: p1.getPolynomial()) {
			result.add(m.deriveMonome());
		}
		return new Polynomial(result);
	}

	
}