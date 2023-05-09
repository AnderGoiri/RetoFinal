package logicTier;

import java.util.Set;

import exceptions.ProductFoundException;
import exceptions.ProductNotFoundException;
import model.Product;

public interface ProductManagerControllable {
	
	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException;
	
	public void addProduct(Product p) throws ProductFoundException;

	public void modifyProduct(Product p) throws ProductNotFoundException;
	/**
	 * This method checks within the database to see if the selected product exists
	 * TODO Move to ProductManager, its only useful there
	 * TODO Exception
	 * @author Jago
	 */
	public boolean existsProduct(int search);
}
