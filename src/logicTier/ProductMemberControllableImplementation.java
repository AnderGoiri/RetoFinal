package logicTier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import model.Product;

public class ProductMemberControllableImplementation implements ProductMemberControllable {

	private Connection con;
	private PreparedStatement stmt;
	private GateDB connection = new GateDB();
	
	@Override
	public Set<Product> searchProduct(String search) {
		Result rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		
		return listaProductos;
	}

	@Override
	public Set<Product> searchProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> searchProductByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> searchProductByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> searchProductByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product purchaseProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product checkProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> checkPurchaseRecord(Product p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

