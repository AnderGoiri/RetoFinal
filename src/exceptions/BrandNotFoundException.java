package exceptions;

public class BrandNotFoundException extends Exception{


	private static final long serialVersionUID = 1L;

	public BrandNotFoundException() {
		super();
	}
	
	public BrandNotFoundException(String mensaje) {
		super(mensaje);
	}
}
