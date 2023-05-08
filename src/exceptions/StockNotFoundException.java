package exceptions;

public class StockNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public StockNotFoundException() {
		super();
	}
	
	public StockNotFoundException(String mensaje) {
		super(mensaje);
	}
}
