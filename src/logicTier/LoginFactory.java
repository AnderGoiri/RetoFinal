package logicTier;

/**
 * 
 * @author Ander
 * 
 *         LoginFactory
 *
 */
public class LoginFactory {
	
	// private static LoginControllable obj= new LoginControllableImplementation();

	/**
	 * Method to create a LoginControllableImplementation Object
	 * @return
	 */
	public static LoginControllable getLoginControllable() {
		return new LoginControllableImplementation();
		//return obj;
	}
}
