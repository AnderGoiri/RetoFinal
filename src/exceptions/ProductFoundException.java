package exceptions;

public class ProductFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductFoundException() {
		super();
	}
	
	public ProductFoundException(String mensaje) {
		super(mensaje);
	}
}
