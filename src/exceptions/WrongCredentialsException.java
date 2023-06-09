package exceptions;

/**
 * 
 * Exception thrown when the credentials added by the user do not match the ones
 * in the database.
 *
 * @author Ander Goirigolzarri Iturburu
 */
public class WrongCredentialsException extends Exception {

	public WrongCredentialsException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
