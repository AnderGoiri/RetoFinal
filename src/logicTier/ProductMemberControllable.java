package logicTier;

import java.util.Set;

import exceptions.BrandNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.NameNotFoundException;
import exceptions.ProductNotFoundException;
import exceptions.TypeNotFoundException;
import model.Member;
import model.Product;

public interface ProductMemberControllable {
	public Set<Product> searchInstrument(String search) throws ProductNotFoundException;
	
	public Set<Product> searchComponent(String search) throws ProductNotFoundException;
	
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException;
	
	public Product searchProductById(int pId, Set<Product> listaProd);
	
	public Set<Product> searchProductByName(String name, Set<Product> listaProd) throws NameNotFoundException;
	
	public Set<Product> searchProductByBrand(String brand, Set<Product> listaProd) throws BrandNotFoundException;
	
	public Set<Product> searchProductByModel(String model, Set<Product> listaProd) throws ModelNotFoundException;
	
	public Set<Product> searchProductByType(String type, Set<Product> listaProd) throws TypeNotFoundException;
	
	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd) throws TypeNotFoundException;
	
	public void purchaseProduct(Product p) throws ProductNotFoundException;

	public boolean checkProduct(Product p) throws ProductNotFoundException;
	
	public Set<Product> checkPurchaseRecord(Member m) throws ProductNotFoundException;
	
	
}