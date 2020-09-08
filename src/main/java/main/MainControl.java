package main;
import java.math.BigDecimal;
import java.util.ArrayList;

import controller.ControllerPolyProcessor;
import controller.Operation;
import model.BiResult;
import model.Monomial;
import model.Polynomial;
import view.ViewPolyProcessor;
import controller.Extractor;
import view.*;
public class MainControl {

	public static void main(String args[]) {
 
		ViewPolyProcessor view = new ViewPolyProcessor();
		ControllerPolyProcessor controller = new ControllerPolyProcessor(view);
		view.setVisible(true);
	}
}
