package logicTier;

/**
 * 
 * Factory class for creating instances of ProductManagerControllable. The
 * factory provides a single instance of
 * ProductManagerControllableImplementation.
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class ProductManagerFactory {

	private static ProductManagerControllable obj = new ProductManagerControllableImplementation();

	/**
	 * Method to create a LoginControllableImplementation Object
	 * 
	 * @return
	 */
	public static ProductManagerControllable getProductManagerControllable() {
		return obj;
	}

}
