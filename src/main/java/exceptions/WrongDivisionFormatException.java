package exceptions;

public class WrongDivisionFormatException extends Throwable{
		
	public WrongDivisionFormatException() {
			// TODO Auto-generated constructor stub
		}
	
	public WrongDivisionFormatException(String msg) {
		System.out.println(msg);
	}
}
