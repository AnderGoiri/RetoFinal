package logicTier;
/**
 * 
 * @author Jagoba Bartolomé Barroso
 *
 */
public class ProductMemberFactory {
	private static ProductMemberControllable obj = new ProductMemberControllableImplementation();
	/**
	 * Method to create a ProductMemberControllable Object
	 * @return
	 */
	public static ProductMemberControllable getProductMember() {
		return obj;
		
	}
}
