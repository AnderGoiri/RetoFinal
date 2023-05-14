package logicTier;

import java.sql.SQLException;
import java.util.Set;

import exceptions.ProductFoundException;
import exceptions.ProductNotFoundException;
import model.Manager;
import model.Product;

public interface ProductManagerControllable {
	
	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException;
	
	public void addProduct(Product p) throws ProductFoundException;

	public void modifyProduct(Product p) throws ProductNotFoundException;

	public void removeProduct(Product p) throws ProductNotFoundException;
	
	public boolean existsProduct(int search) throws ProductNotFoundException;
	
	public void modifyManager(Manager m);
	
	public Set<Product> getAllProducts() throws SQLException;
}
