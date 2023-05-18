package logicTier;

/**
 * Factory class for creating instances of ProductMemberControllable. The
 * factory provides a single instance of
 * ProductMemberControllableImplementation.
 * 
 * @author Jagoba Bartolomé Barroso
 */
public class ProductMemberFactory {
	private static ProductMemberControllable obj = new ProductMemberControllableImplementation();

	/**
	 * Method to create a ProductMemberControllable Object
	 * 
	 * @return a a ProductMemberControllable Object
	 */
	public static ProductMemberControllable getProductMember() {
		return obj;

	}
}
