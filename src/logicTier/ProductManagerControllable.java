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

	public Set<Product> searchProductByName(String name, Set<Product> listaProd);

	public Set<Product> searchProductByBrand(String brand, Set<Product> listaProd);

	public Set<Product> searchProductByModel(String model, Set<Product> listaProd);

	public Set<Product> searchProductByType(String type, Set<Product> listaProd);

	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd);

	public Set<Product> searchProductInSale(Set<Product> listaProd);

	public void setSale(Product p, int sale) throws ProductNotFoundException, SQLException;

	public void removeSale(Product p) throws ProductNotFoundException, SQLException;

	public Set<Manager> getListPending() throws SQLException;

	public char getTypeProduct(int idProduct) throws SQLException;

	public void deleteProduct(Product p) throws ProductNotFoundException, SQLException;
}