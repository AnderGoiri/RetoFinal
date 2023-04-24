package logicTier;

import java.util.Set;

import model.Product;

public interface ProductMemberControllable {
	public Set<Product> searchProduct(String search);
	
	public Set<Product> searchProductByName(String name);
	
	public Set<Product> searchProductByBrand(String brand);
	
	public Set<Product> searchProductByModel(String model);
	
	public Set<Product> searchProductByType(String type);
	
	public Product purchaseProduct(Product p);
	
	public Product checkProduct(Product p);
	
	public Set<Product> checkPurchaseRecord(Product p);
	
	
}