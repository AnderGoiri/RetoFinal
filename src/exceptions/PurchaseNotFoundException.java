package exceptions;

public class PurchaseNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public PurchaseNotFoundException() {
		super();
	}
	
	public PurchaseNotFoundException(String mensaje) {
		super(mensaje);
	}
}
