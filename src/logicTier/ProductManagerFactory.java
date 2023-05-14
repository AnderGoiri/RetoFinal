package logicTier;

/**
*
*
*
*@author Ander Goirigolzarri Iturburu
*/
public class ProductManagerFactory {
	
	private static ProductManagerControllable obj= new ProductManagerControllableImplementation();

	/**
	 * Method to create a LoginControllableImplementation Object
	 * @return
	 */
	public static ProductManagerControllable getProductManagerControllable() {
		return obj;
	}
}
