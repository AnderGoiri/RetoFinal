package logicTier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import exceptions.ProductNotFoundException;
import model.Product;

public class ProductManagerControllableImplementation implements ProductManagerControllable{
	//DB Connection
	private Connection con;
	private PreparedStatement stmt;
	private CallableStatement ctmt;
	private GateDB connection = new GateDB();
	
	/**
	 * Method for the search of products filtered by id
	 * In the parameter list of products, the method searches the one thats equal to the id
	 * @return a list of products
	 * @throws ProductNotFoundException if it doesn't exist
	 * @author Jago
	 */
	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException {
		Product pAux = null;
		for (Product prod : listaProd) {
			if (prod.getIdProduct() == pId) {
				pAux = prod;
			}
		}
		if (pAux != null) {
			return pAux;
		} else {
			throw new ProductNotFoundException();
		}
	}
	
	public void addProduct(Product p) {
		try {
			p.getNameP();
			if (!existsProduct(p)) {
				
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e1) {
			
		}
		
		
		
		
	}
	
	/**
	 * This method checks within the database to see if the selected product exists
	 * TODO Move to ProductManager, its only useful there
	 * TODO Exception
	 * @author Jago
	 */
	@Override
	public boolean existsProduct(int search) {
		boolean existe = false;

		try {
			con = connection.openConnection();
			
			ctmt = con.prepareCall("{CALL check_product_exists(?, ?)}");
			ctmt.setInt(1, search);

			ctmt.executeQuery();
			existe = ctmt.getObject(2, boolean.class);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
}
