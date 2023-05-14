package logicTier;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import exceptions.ProductFoundException;
import exceptions.ProductNotFoundException;
import model.Accessory;
import model.Component;
import model.Instrument;
import model.Product;

public class ProductManagerControllableImplementation implements ProductManagerControllable{
	//DB Connection
	private Connection con;
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
	/**
	 * Method to add a product, if it doesn't exist, to the database
	 * @param Product p that the manager wants to add to the db
	 * @throws ProductFoundException meaning the Product we want to add already exists
	 * @author Jago
	 */
	public void addProduct(Product p) throws ProductFoundException {
		try {
			if (!existsProduct(p.getIdProduct())) {
				con = connection.openConnection();

				if (p instanceof Instrument) {
					ctmt = con.prepareCall("{CALL insert_new_instrument(?,?,?,?,?,?,?,?,?,?,?,?}");
					
					ctmt.setString(1, p.getBrand());
					ctmt.setString(2, p.getModel());
					ctmt.setString(3, p.getDescriptionP());
					ctmt.setFloat(4, p.getPrice());
					ctmt.setInt(5, p.getStock());
					ctmt.setBoolean(6, true);
					ctmt.setBoolean(7, p.isSaleActive());
					ctmt.setInt(8, p.getSalePercentage());
					ctmt.setString(9, p.getNameP());
					ctmt.setString(10, p.getColor());
					ctmt.setString(11, ((Instrument) p).getClassInstrument().getLabel());
					ctmt.setString(12, ((Instrument) p).getTypeInstrument().getLabel());
				}
				if (p instanceof Component) {
					ctmt = con.prepareCall("{CALL insert_new_component(?,?,?,?,?,?,?,?,?,?,?,?}");
					
					ctmt.setString(1, p.getBrand());
					ctmt.setString(2, p.getModel());
					ctmt.setString(3, p.getDescriptionP());
					ctmt.setFloat(4, p.getPrice());
					ctmt.setInt(5, p.getStock());
					ctmt.setBoolean(6, true);
					ctmt.setBoolean(7, p.isSaleActive());
					ctmt.setInt(8, p.getSalePercentage());
					ctmt.setString(9, p.getNameP());
					ctmt.setString(10, p.getColor());
					ctmt.setString(11, ((Component) p).getClassComponent().getLabel());
					ctmt.setString(12, ((Component) p).getTypeComponent().getLabel());	
				}
				if (p instanceof Accessory) {
					ctmt = con.prepareCall("{CALL insert_new_accessory(?,?,?,?,?,?,?,?,?,?,?,?}");
					
					ctmt.setString(1, p.getBrand());
					ctmt.setString(2, p.getModel());
					ctmt.setString(3, p.getDescriptionP());
					ctmt.setFloat(4, p.getPrice());
					ctmt.setInt(5, p.getStock());
					ctmt.setBoolean(6, true);
					ctmt.setBoolean(7, p.isSaleActive());
					ctmt.setInt(8, p.getSalePercentage());
					ctmt.setString(9, p.getNameP());
					ctmt.setString(10, p.getColor());
					ctmt.setString(11, ((Accessory) p).getClassAccessory().getLabel());
					ctmt.setString(12, ((Accessory) p).getTypeAccessory().getLabel());
				}	
			} else {
				throw new ProductFoundException();
			}

		} catch (SQLException e1) {
			//TODO Aqui qué
		} finally {
			connection.closeConnection();
		}
		
	}
	/**
	 * Modifies the located product in the database with the new data
	 * @param A product with the already modified attributes
	 * @throws ProductNotFoundException The product we want to modify doesn't exist in the database
	 * @author Jago
	 */
	public void modifyProduct(Product p) throws ProductNotFoundException {
		if (existsProduct(p.getIdProduct())) {
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE product SET brand=?, model=?, description=?, unitPrice=?, stock=?, isActive=?, saleActive=?, salePercentage=?, name=?, color=?");
				ctmt.setString(1, p.getBrand());
				ctmt.setString(2, p.getModel());
				ctmt.setString(3, p.getDescriptionP());
				ctmt.setFloat(4, p.getPrice());
				ctmt.setInt(5, p.getStock());
				ctmt.setBoolean(6, true);
				ctmt.setBoolean(7, p.isSaleActive());
				ctmt.setInt(8, p.getSalePercentage());
				ctmt.setString(9, p.getNameP());
				ctmt.setString(10, p.getColor());
				
				ctmt.executeUpdate();
				if (p instanceof Instrument) {
					ctmt = con.prepareCall("UPDATE instrument SET classInstrument=?, typeInstrument=?");
					ctmt.setString(11, ((Instrument) p).getClassInstrument().getLabel());
					ctmt.setString(12, ((Instrument) p).getTypeInstrument().getLabel());
					ctmt.executeUpdate();
				}
				if (p instanceof Component) {
					ctmt = con.prepareCall("UPDATE component SET classComponent=?, typeComponent=?");
					ctmt.setString(11, ((Component) p).getClassComponent().getLabel());
					ctmt.setString(12, ((Component) p).getTypeComponent().getLabel());
					ctmt.executeUpdate();
				}
				if (p instanceof Accessory) {
					ctmt = con.prepareCall("UPDATE accessory SET classAccessory=?, typeAccessory=?");
					ctmt.setString(11, ((Accessory) p).getClassAccessory().getLabel());
					ctmt.setString(12, ((Accessory) p).getTypeAccessory().getLabel());
					ctmt.executeUpdate();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.closeConnection();
			}
		} else {
			throw new ProductNotFoundException();
		}
		
	}
	/**
	 * This method checks within the database (with a cursor) to see if the selected product exists
	 * @param int search is the id of the product we want to search
	 * @return returns false if the product doesn't exist in the database
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
		} finally {
			connection.closeConnection();
		}
		return existe;
	}
	
	/**
	 * This method sets the product to inactive so it won't show to the members
	 * @param Product p is the one the manager wants to remove
	 * @author Jago
	 */
	@Override
	public void removeProduct(Product p) throws ProductNotFoundException {
		if (existsProduct(p.getIdProduct()) && (p.isActive() == true)) {
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE product SET isActive=?");

				ctmt.setBoolean(1, false);
				ctmt.executeQuery();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.closeConnection();
			}
		} else {
			throw new ProductNotFoundException();
		}

	}
	/**
	 * This method sets the sale of a product to active, sets how much it discounts and the new price
	 * @param Product p is the product in which we'll add a sale, int sale is how much it has the price reduced
	 * @throws ProductNotFoundException
	 * @author Jago
	 */
	public void setSale(Product p, int sale) throws ProductNotFoundException {
		if (existsProduct(p.getIdProduct()) && (p.isActive() == true)) {
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE product SET saleActive=?, sale=?, unitPrice=?");

				ctmt.setBoolean(1, true);
				ctmt.setInt(2, sale);
				ctmt.setFloat(3, p.getPrice()*(sale/100));
				ctmt.executeQuery();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection.closeConnection();
			}
		} else {
			throw new ProductNotFoundException();
		}
		
	}
	/**
	 * This method removes the saleActive flag
	 * @param Product p is the product we want to 
	 * @throws ProductNotFoundException
	 */
	public void removeSale(Product p) throws ProductNotFoundException {
		if (existsProduct(p.getIdProduct()) && (p.isActive() == true)) {
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE product SET saleActive=?");

				ctmt.setBoolean(1, false);
				ctmt.executeQuery();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.closeConnection();
			}
		} else {
			throw new ProductNotFoundException();
		}
	}

}