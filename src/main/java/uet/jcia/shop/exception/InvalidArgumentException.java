package uet.jcia.shop.exception;

public class InvalidArgumentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidArgumentException() {
	}
	
	public InvalidArgumentException(String message) {
		super(message);
	}
}
