package logicTier;

import java.sql.SQLException;
import java.util.Set;

import exceptions.BrandNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.NameNotFoundException;
import exceptions.ProductNotFoundException;
import exceptions.PurchaseNotFoundException;
import exceptions.StockNotFoundException;
import exceptions.TypeNotFoundException;
import model.Member;
import model.Product;
import model.Purchase;

public interface ProductMemberControllable {
	public Set<Product> searchInstrument(String search) throws ProductNotFoundException, SQLException;
	
	public Set<Product> searchComponent(String search) throws ProductNotFoundException, SQLException;
	
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException, SQLException;
	
	public Set<Product> searchProductByName(String name, Set<Product> listaProd) throws NameNotFoundException;
	
	public Set<Product> searchProductByBrand(String brand, Set<Product> listaProd) throws BrandNotFoundException;
	
	public Set<Product> searchProductByModel(String model, Set<Product> listaProd) throws ModelNotFoundException;
	
	public Set<Product> searchProductByType(String type, Set<Product> listaProd) throws TypeNotFoundException;
	
	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd) throws TypeNotFoundException;
	
	public Set<Product> searchProductInSale(Set<Product> listaProd);
	
	public boolean checkProduct(Product p) throws Exception;
	
	public Purchase addProductPurchase(Purchase pset, Product p, Member m) throws StockNotFoundException, ProductNotFoundException, SQLException, Exception; 
	
	public Purchase searchPurchase(Member m);
	
	public Purchase removeProduct(Purchase pset, Product p) throws Exception;
	
	public Purchase removePurchase(Purchase pset) throws PurchaseNotFoundException, SQLException;

	public Set<Purchase> getListPurchase(Member m) throws PurchaseNotFoundException, SQLException;
	
	public char getTypeProduct(int idProduct) throws SQLException;
	
	public void modifyMember(Member m, String username) throws SQLException;

	public Set<Product> getAllProducts(String search) throws SQLException;

	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException;

	public Set<Purchase> addPurchase(Product p, Member m) throws SQLException, StockNotFoundException, ProductNotFoundException;
	
}