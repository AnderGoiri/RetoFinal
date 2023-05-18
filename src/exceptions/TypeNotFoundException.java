package exceptions;

public class TypeNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public TypeNotFoundException() {
		super();
	}
	
	public TypeNotFoundException(String mensaje) {
		super(mensaje);
	}
}
