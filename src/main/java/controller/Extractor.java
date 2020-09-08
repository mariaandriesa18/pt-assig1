package controller;

import java.math.BigDecimal;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import exceptions.WrongDivisionFormatException;
import model.Monomial;
import model.Polynomial;

public class Extractor {
	
	public Extractor() {
	
	}

	public static Polynomial extractPolyFromString(String poly) throws WrongDivisionFormatException {
		Pattern pattern = null;
        Matcher p = null;
		ArrayList<Monomial> res = new ArrayList<Monomial>();
		int i = 0 ;
		boolean correctInput = false;
		
		pattern = Pattern.compile("(-?\\b\\d+)x\\^(-?\\d+\\b)");
		p = pattern.matcher(poly);
			
		while (p.find() ) { 
			
				try {
					res.add(i, extractMonomial(p.group(1), p.group(2)));
				} catch (WrongDivisionFormatException e) {
					throw new WrongDivisionFormatException();
				}
				++i;
	
		}	

		return new Polynomial(res);
	
	}


	
	public static Monomial extractMonomial(String coeff, String exp) throws WrongDivisionFormatException {
		Monomial monom = new Monomial();
		BigDecimal co = new BigDecimal(coeff);
		Integer ex = Integer.parseInt(exp);
		if(co.equals(new BigDecimal(0)) || ex < 0) {
			throw new WrongDivisionFormatException();
		}
		monom.setCoefficient(new BigDecimal(coeff));
		monom.setExponent(Integer.parseInt(exp));
		return monom;					
	}	
	
	public static String polyToString(Polynomial p) {
		String resp ="" ;
		for (Monomial e : p.getPolynomial()) {
			if(e.getCoefficient().floatValue() > 0) {
			resp =resp+'+'+ e.getCoefficient().toString()+ "x^"+e.getExponent().toString(); 
		}else if(e.getCoefficient().longValue() < 0){
			resp = resp+ e.getCoefficient().toString() + "x^" +e.getExponent().toString(); 
		     }else if(e.getCoefficient().floatValue() == 0)
		    	 continue;
	      }
		return resp;
	}
}
