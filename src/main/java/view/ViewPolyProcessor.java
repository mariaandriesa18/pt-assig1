package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ViewPolyProcessor extends JFrame {

	private JFrame frame;
	
	private JTextField firstPolyTF = new JTextField(50);
	private JTextField secondPolyTF = new JTextField(50);
	private JTextField resultPolyTF = new JTextField(60);
	private JLabel firstPolyLabel = new JLabel("First polynomial: ");
	private JLabel secondPolyLabel = new JLabel("Second polynomial: ");
	private JLabel resultPolyLabel = new JLabel("Result: ");
	private JButton addBtn = new JButton("Add");
	private JButton subBtn = new JButton("Subtract");
	private JButton divBtn= new JButton("Divide");
	private JButton mulBtn = new JButton("Multiply");
	private JButton integrateBtn = new JButton("Integrate");
	private JButton diffBtn = new JButton("Differentiate");
	
	public ViewPolyProcessor() {
		initialize();
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(firstPolyLabel);
		p1.add(firstPolyTF);
		p1.add(integrateBtn);
		p1.add(diffBtn);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(addBtn);
		p2.add(subBtn);
		p2.add(mulBtn);
		p2.add(divBtn);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(secondPolyLabel);
		secondPolyLabel.setHorizontalAlignment(JLabel.LEFT);
		p3.add(secondPolyTF);
		secondPolyTF.setHorizontalAlignment(JTextField.LEFT);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.add(resultPolyLabel);
		resultPolyLabel.setHorizontalAlignment(JLabel.LEFT);
		p4.add(resultPolyTF);
		resultPolyTF.setHorizontalAlignment(JTextField.LEFT);
		
		JPanel mainp = new JPanel();
		mainp.setLayout(new GridLayout(4,1));
		mainp.add(p1);
		mainp.add(p3);
		mainp.add(p2);
		mainp.add(p4);
		
		this.setContentPane(mainp);
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}

	private  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addAdditionListener(ActionListener e) {
		this.addBtn.addActionListener(e);
	}
	
	public void addSubtractListener(ActionListener e) {
		this.subBtn.addActionListener(e);
	}
	
	
	public void addMultiplicationListener(ActionListener e) {
		this.mulBtn.addActionListener(e);
	}
	
	public void addDivisionListener(ActionListener e) {
		this.divBtn.addActionListener(e);
	}
	
	public void addDifferentiationListener(ActionListener e) {
		this.diffBtn.addActionListener(e);
	}
	
	public void addIntegrationListener(ActionListener e) {
		this.integrateBtn.addActionListener(e);
	}
	
	public String getFirstPolynomial() {
		return this.firstPolyTF.getText();
	}
	public String getSecondPolynomial() {
		return this.secondPolyTF.getText();
	}
	
	public void setResult(String p) {
		this.resultPolyTF.setText(p);
	}
	
	public void showError(String errorMessage, String title) {
	    JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	} 


}
