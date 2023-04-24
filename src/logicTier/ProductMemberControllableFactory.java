package logicTier;

public class ProductMemberControllableFactory {
	public ProductMemberControllableImplementation getProductMember() {
		return new ProductMemberControllableImplementation();
		
	}
}
