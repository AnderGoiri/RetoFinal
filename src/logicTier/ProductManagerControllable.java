package logicTier;

import java.sql.SQLException;
import java.util.Set;

import exceptions.ProductFoundException;
import exceptions.ProductNotFoundException;
import model.Manager;
import model.Product;

public interface ProductManagerControllable {
	
	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException;
	
	public void addProduct(Product p) throws ProductFoundException, SQLException;

	public void modifyProduct(Product p) throws ProductNotFoundException, SQLException;

	public void removeProduct(Product p) throws ProductNotFoundException, SQLException;
	
	public boolean existsProduct(int search) throws ProductNotFoundException, SQLException;
	
	public void modifyManager(Manager m) throws SQLException;
	
	public Set<Product> getAllProducts() throws SQLException;

	/**
	 * Method for the search of products filtered by name In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
	 * @return a list of products
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductByName(String name, Set<Product> listaProd);

	/**
	 * Method for the search of products filtered by brand In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
	 * @return a list of products
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductByBrand(String brand, Set<Product> listaProd);

	/**
	 * Method for the search of products filtered by model In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
	 * @return a list of products
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductByModel(String model, Set<Product> listaProd);

	/**
	 * The method searches in the list already provided by a previous search to
	 * match the Type of Product selected. It iterates the list and checks the type
	 * of object of the Products. Once it is inside it transforms the String type
	 * value to an enum and if its equal type is the filter referring to the type of
	 * product (Acoustic or Electric) listaProd is the list of products already
	 * searched
	 * 
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductByType(String type, Set<Product> listaProd);

	/**
	 * The method searches in the list already provided by a previous search to
	 * match the Class of Product selected. It iterates the list and checks the
	 * class of object of the Products. Once it is inside it transforms the String
	 * class value to an enum and if its equal type is the filter referring to the
	 * type of product (Acoustic or Electric) listaProd is the list of products
	 * already searched
	 * 
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd);

	/**
	 * This method searches in a product list for products with any sale
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductInSale(Set<Product> listaProd);
}
