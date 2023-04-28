package logicTier;

import java.util.Set;

import exceptions.BrandNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.NameNotFoundException;
import exceptions.ProductNotFoundException;
import exceptions.TypeNotFoundException;
import model.Product;

public interface ProductMemberControllable {
	public Set<Product> searchInstrument(String search) throws ProductNotFoundException;
	
	public Set<Product> searchComponent(String search) throws ProductNotFoundException;
	
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException;
	
	public Set<Product> searchProductByName(String name) throws NameNotFoundException;
	
	public Set<Product> searchProductByBrand(String brand) throws BrandNotFoundException;
	
	public Set<Product> searchProductByModel(String model) throws ModelNotFoundException;
	
	public Set<Product> searchProductByType(String type) throws TypeNotFoundException;
	
	public Product purchaseProduct(Product p) throws ProductNotFoundException;
	
	public Product checkProduct(Product p) throws ProductNotFoundException;
	
	public Set<Product> checkPurchaseRecord(Product p) throws ProductNotFoundException;
	
	
}