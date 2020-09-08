package controller;

import model.Monomial;
import model.Polynomial;
import java.util.*;

public class IntegrateOp extends Operation<Polynomial>{

	public IntegrateOp() {
	  
	}

	@Override
	public Polynomial calculate(Polynomial p1, Polynomial p2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial calculateOne(Polynomial p1) {
		
		ArrayList<Monomial> res = new ArrayList<Monomial>();
		for(Monomial m: p1.getPolynomial()) {
			res.add(m.integrateMonome());
		}
		return new Polynomial(res);
	}

}
