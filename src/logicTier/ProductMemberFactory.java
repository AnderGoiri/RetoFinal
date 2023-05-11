package logicTier;

public class ProductMemberFactory {
	private static ProductMemberControllable obj = new ProductMemberControllableImplementation();
	
	public static ProductMemberControllable getProductMember() {
		return obj;
		
	}
}
