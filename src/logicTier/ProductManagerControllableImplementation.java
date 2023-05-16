package logicTier;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import exceptions.ProductFoundException;
import exceptions.ProductNotFoundException;
import model.Accessory;
import model.Component;
import model.EnumClassAccessory;
import model.EnumClassComponent;
import model.EnumClassInstrument;
import model.EnumStatusManager;
import model.EnumTypeAccessory;
import model.EnumTypeComponent;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Manager;
import model.Member;
import model.Product;
import model.Purchase;

public class ProductManagerControllableImplementation implements ProductManagerControllable{
	//DB Connection
	private Connection con;
	private CallableStatement ctmt;
	private PreparedStatement stmt;
	private GateDB connection = new GateDB();
	private ResultSet rset;
	//Attributes
	Product prod;
	
	/**
	 * Method for the search of products filtered by id
	 * In the parameter list of products, the method searches the one thats equal to the id
	 * @param int pId is the id of the product we want to search, listaProd is the list of all products
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
					
					ctmt.executeQuery();
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
					ctmt.executeQuery();
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
					ctmt.executeQuery();
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
	
	/**
	 * This method changes the manager's info in the database
	 * @param Manager m is the current logged-in manager with the attributes already changed
	 * @author Jago
	 */
	public void modifyManager(Manager m) {
		con = connection.openConnection();
		
		try {
			ctmt = con.prepareCall("UPDATE user SET username=?, name=?, surname=?, mail=?");
			ctmt.setString(1, m.getUserName());
			ctmt.setString(2, m.getName());
			ctmt.setString(3, m.getSurname());
			ctmt.setString(4, m.getMail());
			ctmt.executeQuery();
			
			ctmt = con.prepareCall("UPDATE manager SET idSupervisor=?, isSupervisor=?, isTechnician=?, isAdmin=?, statusManager=? ");
			ctmt.setInt(1, m.getIdSupervisor());
			ctmt.setBoolean(2, m.isSupervisor());
			ctmt.setBoolean(3, m.isTechnician());
			ctmt.setBoolean(4, m.isAdmin());
			ctmt.setString(5, m.getStatusManager().getLabel());
			
			ctmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
	}

	/**
	 * Method to get the list of Managers with status Pending to let the Admin approve them
	 * @return
	 */
	//TODO
	public Set<Manager> getListPending(){
		ResultSet rs = null;
		Set<Manager> listaManagers = new HashSet<Manager>();
		Manager m = null;
		
		try {		
			con = connection.openConnection();

			ctmt = con.prepareCall("{CALL select_manager()}");
			rs = ctmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("statusManager").equals("Pending")) {
						m = new Manager();
						m.setUserName(rs.getString("username"));
						m.setName(rs.getString("name"));
						m.setSurname(rs.getString("surname"));
						m.setPassword(rs.getString("password"));
						m.setMail(rs.getString("mail"));
						LocalDate date = LocalDate.parse(rs.getString("date"));
						m.setDateRegister(date);
						m.setIdSupervisor(rs.getInt("idSupervisor"));
						m.setTechnician(rs.getBoolean("isTechnician"));
						m.setAdmin(rs.getBoolean("isAdmin"));
						m.setStatusManager(EnumStatusManager.valueOf(rs.getString("statusManager")));
						listaManagers.add(m);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				connection.closeConnection(ctmt, con, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return listaManagers;
		
	}
	
	/**
	 * Retrieves the type of product based on the given product ID.
	 *
	 * @param idProduct The ID of the product.
	 * @return A character representing the type of product:
	 *         - 'I' for Instrument
	 *         - 'C' for Component
	 *         - 'A' for Accessory
	 *         - 'U' for Unknown (product not found in any table)
	 * @throws SQLException if a database access error occurs.
	 * @author Ander Goirigolzarri Iturburu
	 */
	public char getTypeProduct(int idProduct) throws SQLException {
		con = connection.openConnection();

		// Check if the idProduct exists in the instrument table
		String queryInstrument = "SELECT idProduct FROM instrument WHERE idProduct = ?";
		PreparedStatement stmtInstrument = con.prepareStatement(queryInstrument);
		stmtInstrument.setInt(1, idProduct);
		ResultSet rsInstrument = stmtInstrument.executeQuery();
		if (rsInstrument.next()) {
			return 'I'; // 'I' represents Instrument
		}

		// Check if the idProduct exists in the component table
		String queryComponent = "SELECT idProduct FROM component WHERE idProduct = ?";
		PreparedStatement stmtComponent = con.prepareStatement(queryComponent);
		stmtComponent.setInt(1, idProduct);
		ResultSet rsComponent = stmtComponent.executeQuery();
		if (rsComponent.next()) {
			return 'C'; // 'C' represents Component
		}

		// Check if the idProduct exists in the accessory table
		String queryAccessory = "SELECT idProduct FROM accessory WHERE idProduct = ?";
		PreparedStatement stmtAccessory = con.prepareStatement(queryAccessory);
		stmtAccessory.setInt(1, idProduct);
		ResultSet rsAccessory = stmtAccessory.executeQuery();
		if (rsAccessory.next()) {
			return 'A'; // 'A' represents Accessory
		}
		return 'U'; // 'U' represents Unknown (product not found in any table)
	}

	/**
	 * Retrieves all products from the database.
	 *
	 * @return A set of Product objects representing all the products.
	 * @throws SQLException if a database access error occurs.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Override
	public Set<Product> getAllProducts() throws SQLException {
		con = connection.openConnection();
		ctmt = con.prepareCall("{CALL select_all_products}");
		rset = ctmt.executeQuery();

		Set<Product> setProducts = new HashSet<Product>();

		while (rset.next()) {
			int idProduct = rset.getInt("idProduct");
			String name = rset.getString("name");
			float unitPrice = rset.getInt("unitPrice");
			String description = rset.getString("description");
			int stock = rset.getInt("stock");
			String brand = rset.getString("brand");
			String model = rset.getString("model");
			String color = rset.getString("color");
			boolean saleActive = rset.getBoolean("saleActive");
			int salePercentage = rset.getInt("salePercentage");
			boolean isActive = rset.getBoolean("isActive");

			if (getTypeProduct(idProduct) == 'I') { // check if the value exists in the instrument table
				EnumClassInstrument classInstrument = EnumClassInstrument.getValue(rset.getString(12));
				EnumTypeInstrument typeInstrument = EnumTypeInstrument.getValue(rset.getString(13));

				Instrument instrument = new Instrument(idProduct, name, unitPrice, description, stock, brand, model,
						color, saleActive, salePercentage, isActive, classInstrument, typeInstrument);

				setProducts.add(instrument);

			} else if (getTypeProduct(idProduct) == 'C') { // check if the value exists in the component table
				EnumClassComponent classComponent = EnumClassComponent.getValue(rset.getString(12));

				EnumTypeComponent typeComponent = EnumTypeComponent.getValue(rset.getString(13));

				Component component = new Component(idProduct, name, unitPrice, description, stock, brand, model, color,
						saleActive, salePercentage, isActive, classComponent, typeComponent);

				setProducts.add(component);

			} else if (getTypeProduct(idProduct) == 'A') { // check if the value exists in the accessory table
				EnumClassAccessory classAccessory = EnumClassAccessory.getValue(rset.getString(12));

				EnumTypeAccessory typeAccessory = EnumTypeAccessory.getValue(rset.getString(13));

				Accessory accessory = new Accessory(idProduct, name, unitPrice, description, stock, brand, model, color,
						saleActive, salePercentage, isActive, classAccessory, typeAccessory);

				setProducts.add(accessory);
			}
		}
		return setProducts;
	}
}
