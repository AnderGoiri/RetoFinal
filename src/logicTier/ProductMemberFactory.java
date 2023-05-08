package logicTier;

public class ProductMemberFactory {
	private static ProductMemberControllable obj = new ProductMemberControllableImplementation();
	
	public ProductMemberControllable getProductMember() {
		return obj;
		
	}
}
