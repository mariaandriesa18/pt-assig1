package model;
import controller.*;
import controller.Extractor;

public class BiResult {
	
	private Polynomial quot = new Polynomial();
	private Polynomial rem = new Polynomial();
	
	public BiResult() {
		
	}
	
	public BiResult(Polynomial quot, Polynomial rem) {
		this.quot = quot;
		this.rem = rem;
	}
	
	public String getDivisionResultString() {
		return "quotient : " + Extractor.polyToString(quot)+"  remainder: " + Extractor.polyToString(rem);
	}
	
	public Polynomial getQuot() {
		return this.quot.getDescSortedPolynomial();
	}
	public void setQuot(Polynomial quot) {
		this.quot = quot;
	}
	
	public void setRem(Polynomial rem) {
		this.rem = rem;
	}

	public Polynomial getRem() {
		return this.rem.getDescSortedPolynomial();
	}
	
}
