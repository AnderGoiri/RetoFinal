package exceptions;

public class ComponentNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ComponentNotFoundException() {
		super();
	}
	
	public ComponentNotFoundException(String mensaje) {
		super(mensaje);
	}
}
