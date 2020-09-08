package controller;
import java.util.ArrayList;

import model.Monomial;
import model.Polynomial;

public abstract class Operation<T> {
	
	
	public static Operation<?> getInstance(String op) {
		if(op.equals("Add") ) {
			return new AddOp();
			}
			else if (op.equals("Subtract")) {
				return new SubtractOp();
			}else if(op.equals("Multiply")) {
				return new MultiplyOp();
			}else if(op.equals("Divide")) {
				return new DivideOp();
			}else if(op.equals("Integrate")) {
				return new IntegrateOp();
			}else if(op.equals("Derive")) {
				return new DeriveOp();
			}
		return null;
	}
	public abstract T calculate(Polynomial p1, Polynomial p2);
	public abstract T  calculateOne(Polynomial p1) ;
}











