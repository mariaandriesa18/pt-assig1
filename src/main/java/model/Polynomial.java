package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import controller.Extractor;

public class Polynomial {

	private  ArrayList<Monomial> polynomial = new ArrayList<Monomial>() ;
	
	public Polynomial() {
	
	}
	public Polynomial ( ArrayList<Monomial> p) {
		this.polynomial = p;
	}
	
	public ArrayList<Monomial> getPolynomial() {
		return polynomial;
	}


	
	public Integer getLen() {
		return this.polynomial.size();
	}
	
	public ArrayList<Integer> getArrayOfExp(){
		 ArrayList<Integer> exps = new  ArrayList<Integer>();
		 for(Monomial el: this.polynomial){
			 exps.add(el.getExponent());
			 }
		 return exps;
	}
	
	public Polynomial getDescSortedPolynomial() {
		Collections.sort(this.polynomial, Collections.reverseOrder());
		return new Polynomial(this.polynomial);
	}
	
	public void copyFromPoly(Polynomial p) {
			this.polynomial.clear();
			for(int j = 0; j < p.getLen(); j++) {
				if(p.getPolynomial().get(j).getCoefficient().compareTo(new BigDecimal(0)) == 0) {
					continue;
				}else
					this.polynomial.add(p.getPolynomial().get(j));
			}
		}
	
	
}











