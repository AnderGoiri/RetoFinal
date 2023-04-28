package exceptions;

public class InstrumentNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InstrumentNotFoundException() {
		super();
	}
	
	public InstrumentNotFoundException(String mensaje) {
		super(mensaje);
	}
}
