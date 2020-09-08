package model;

import java.math.*;
import java.util.Collections;

public class Monomial implements Comparable<Monomial> {
	
	private BigDecimal coefficient;
	private Integer exponent;
	
	public Monomial(){
		
	}
	
	public Monomial(BigDecimal coeff , Integer exp){
		this.coefficient = coeff;
		this.exponent = exp;
	}

	public BigDecimal getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(BigDecimal coefficient) {
		this.coefficient = coefficient;
	}
	
	public Integer getExponent() {
		return exponent;
	}
 
	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}
	
	public Monomial maxMonom( Monomial m2) {
		if(this.exponent > m2.getExponent()) {
			return this;
		}else if(this.exponent < m2.getExponent()){
			return m2;
		}
		return null;
	}

	public int compareTo(Monomial o) {
			if(this.exponent > o.exponent) {
				return 1;
			}else if(this.exponent == o.exponent) {
				return 0;
			}else 
				return -1;
	}
	
	public Monomial multMonome(Monomial o2) {
		Monomial res = new Monomial();
		res.setCoefficient(this.getCoefficient().multiply(o2.getCoefficient()));
		res.setExponent(this.getExponent() + o2.getExponent());
		return res;
	}
	
	public Monomial divMonome(Monomial m2) {
		Monomial res = new Monomial();
		res.setExponent(this.getExponent() - m2.getExponent());
		res.setCoefficient(this.getCoefficient().divide(m2.getCoefficient()));
		return res;
	}
	
	public Monomial integrateMonome() {
		Monomial m = new Monomial();
		BigDecimal nr = new BigDecimal("1");
		Integer exp = this.getExponent() + 1;
		BigDecimal n = nr.divide(new BigDecimal(exp.toString()));
		m.setCoefficient(this.coefficient.multiply(n));
		m.setExponent(this.exponent + 1);
		return m;
	}
	
	public Monomial deriveMonome() {
		Monomial m = new Monomial();
	
		BigDecimal newExp = new BigDecimal(this.exponent.toString());
		m.setCoefficient(this.coefficient.multiply(newExp));
		m.setExponent(this.exponent - 1);
		return m;
	}

}
