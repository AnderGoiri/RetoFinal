package exceptions;

public class AccessoryNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AccessoryNotFoundException() {
		super();
	}
	
	public AccessoryNotFoundException(String mensaje) {
		super(mensaje);
	}
}
