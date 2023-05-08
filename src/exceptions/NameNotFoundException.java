package exceptions;

public class NameNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NameNotFoundException() {
		super();
	}
	
	public NameNotFoundException(String mensaje) {
		super(mensaje);
	}
}
