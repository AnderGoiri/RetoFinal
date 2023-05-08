package exceptions;

/**
 * 
 * Exception thrown when the User is not found in the database and it should be.
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
