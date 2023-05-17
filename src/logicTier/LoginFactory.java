package logicTier;

/**
 * Factory class for creating instances of LoginControllable. The factory
 * provides a single instance of LoginControllableImplementation.
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class LoginFactory {

	private static LoginControllable obj = new LoginControllableImplementation();

	/**
	 * Method to create a LoginControllableImplementation Object
	 * 
	 * @return
	 */
	public static LoginControllable getLoginControllable() {
		return obj;
	}
}
