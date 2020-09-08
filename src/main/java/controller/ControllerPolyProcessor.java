package controller;
import view.ViewPolyProcessor;

import java.awt.Polygon;
import java.awt.event.*;
import java.util.ArrayList;

import model.Polynomial;
import controller.*;
import exceptions.WrongDivisionFormatException;
import model.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControllerPolyProcessor {
	private ViewPolyProcessor view;
	private Polynomial result;
	
	
	public ControllerPolyProcessor(ViewPolyProcessor vw ){
		this.view = vw;

		view.addAdditionListener(new AdditionListener());
		view.addSubtractListener(new SubtractionListener());
		view.addMultiplicationListener(new MultiplyListener());
		view.addDivisionListener(new DivisionListener());
		view.addDifferentiationListener(new DifferentiationListener());
		view.addIntegrationListener(new IntegrationListener());
	}
	
	
	
	public class AdditionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			String poly2 = view.getSecondPolynomial();
			Polynomial p1 = new Polynomial() ;
			Polynomial p2 = new Polynomial();
			try { 
				p1 =Extractor.extractPolyFromString(poly1);
				p2 = Extractor.extractPolyFromString(poly2);
			}catch(WrongDivisionFormatException d) {
				
			}finally {	
			
			@SuppressWarnings("unchecked")
			Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Add");
			result = op.calculate(p1, p2);
			view.setResult(Extractor.polyToString(result));	
			}
		
		}
	}
	
	public class SubtractionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			String poly2 = view.getSecondPolynomial();
			Polynomial p1 = new Polynomial() ;
			Polynomial p2 = new Polynomial();
			try { 
				p1 =Extractor.extractPolyFromString(poly1);
				p2 = Extractor.extractPolyFromString(poly2);
			}catch(WrongDivisionFormatException d) {
				
			}finally {	
			
			@SuppressWarnings("unchecked")
			Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Subtract");
			result = op.calculate(p1, p2);
			view.setResult(Extractor.polyToString(result));	
			}
			
		}
		
		
	}
	
	public class MultiplyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			String poly2 = view.getSecondPolynomial();
			Polynomial p1 = new Polynomial() ;
			Polynomial p2 = new Polynomial();
			try { 
				p1 =Extractor.extractPolyFromString(poly1);
			}catch(WrongDivisionFormatException d) {
				view.showError( "First polynomial is wrongly formatted", "Failure");
				
			}
			
			try {
				p2 = Extractor.extractPolyFromString(poly2);
			}catch(WrongDivisionFormatException v) {
				view.showError( "Second polynomial is wrongly formatted", "Failure");
			}
		
			Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Multiply");
			result = op.calculate(p1, p2);
			view.setResult(Extractor.polyToString(result));	
			
		}
		
		
	}
	
	public class DivisionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			String poly2 = view.getSecondPolynomial();
			Polynomial p1 = new Polynomial() ;
			Polynomial p2 = new Polynomial();
			try { 
				p1 =Extractor.extractPolyFromString(poly1);
			}catch(WrongDivisionFormatException d) {
				view.showError( "First polynomial is wrongly formatted", "Failure");
			}
			
			try {
				p2 = Extractor.extractPolyFromString(poly2);
			}catch(WrongDivisionFormatException v) {
				view.showError( "Second polynomial is wrongly formatted", "Failure");
				return;
			}
			
			@SuppressWarnings("unchecked")
			Operation<BiResult> op = (Operation<BiResult>) Operation.getInstance("Divide");
			BiResult result = op.calculate(p1, p2);
			view.setResult("quot: " + Extractor.polyToString(result.getQuot()) +" rem: " + Extractor.polyToString(result.getRem()));	
			
		}
		
		
	}
	
	public class DifferentiationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			Polynomial p1 = new Polynomial() ;
			try { 
				p1 =Extractor.extractPolyFromString(poly1);
			}catch(WrongDivisionFormatException d) {
				view.showError( "Second polynomial is wrongly formatted", "Failure");
				return;
			}			
				@SuppressWarnings("unchecked")
				Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Derive");
				result = op.calculateOne(p1);
				view.setResult(Extractor.polyToString(result));
			
		
				
			
		}
		
		
	}
	
	public class IntegrationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String poly1 = view.getFirstPolynomial();
			Polynomial p1 = new Polynomial() ;			
		
			try {
				p1 =Extractor.extractPolyFromString(poly1);
			} catch (WrongDivisionFormatException e1) {
				view.showError( "Second polynomial is wrongly formatted", "Failure");
				return;			
			}
			@SuppressWarnings("unchecked")
			Operation<Polynomial> op = (Operation<Polynomial>) Operation.getInstance("Integrate");
			result = op.calculateOne(p1);
			view.setResult(Extractor.polyToString(result));	
			
			
		}
		
		
	}
	
	}
