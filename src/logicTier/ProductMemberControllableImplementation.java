package logicTier;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exceptions.ProductNotFoundException;
import exceptions.PurchaseNotFoundException;
import model.Accessory;
import model.Component;
import model.EnumClassAccessory;
import model.EnumClassComponent;
import model.EnumClassInstrument;
import model.EnumTypeAccessory;
import model.EnumTypeComponent;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Member;
import model.Product;
import model.Purchase;


public class ProductMemberControllableImplementation implements ProductMemberControllable {
	//DB Connection
	private Connection con;
	private PreparedStatement stmt;
	private CallableStatement ctmt;
	private GateDB connection = new GateDB();
	
	//Attributes
	private Product prod;
	
	//Sentencias SQL
	
	/**
	 * Method for the search of products that are instruments
	 * A call for a procedure in the script is made to search products that are instruments.
	 * When they are found, if the instrument has the same brand, model or name as the search made by the user, they are added to a list.
	 * @return a list of instruments
	 * @author Jago
	 */
	@Override
	public Set<Product> searchInstrument(String search) {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();

		try {
			con = connection.openConnection();
			
			ctmt = con.prepareCall("{CALL select_instrument()}");
			rs = ctmt.executeQuery();

			while(rs.next()) {
				if (rs.getString("name").equals(search) || rs.getString("brand").equals(search) || rs.getString("model").equals(search)) {			
					prod = new Instrument();
					
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getFloat("salePercentage"));
					System.out.println(prod.toString());
					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassInstrument enumClassInstr = EnumClassInstrument.valueOf(rs.getString("classInstrument"));
					((Instrument) prod).setClassInstrument(enumClassInstr);

					EnumTypeInstrument enumTypeInstr = EnumTypeInstrument.valueOf(rs.getString("typeInstrument"));
					((Instrument) prod).setTypeInstrument(enumTypeInstr);
				
					listaProductos.add(prod);	
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
		return listaProductos;
	}
	
	/**
	 * Method for the search of products that are components
	 * A call for a procedure in the script is made to search products that are components.
	 * When they are found, if the component has the same brand, model or name as the search made by the user, they are added to a list.
	 * @return a list of components
	 * @author Jago
	 */
	@Override
	public Set<Product> searchComponent(String search){
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		try {
			connection.openConnection();
			
			ctmt = con.prepareCall("{CALL select_component()}");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if (rs.getString("name").equals(search) || rs.getString("brand").equals(search) || rs.getString("model").equals(search)) {			
					prod = new Component();
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getFloat("salePercentage"));

					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassComponent enumClassComp = EnumClassComponent.valueOf(rs.getString("classComponent"));
					((Component) prod).setClassComponent(enumClassComp);

					EnumTypeComponent enumTypeComp = EnumTypeComponent.valueOf(rs.getString("typeComponent"));
					((Component) prod).setTypeComponent(enumTypeComp);
				
					listaProductos.add(prod);	
				}	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				connection.closeConnection(stmt, con, rs);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		return listaProductos;
	}
	/**
	 * Method for the search of products that are accessories
	 * A call for a procedure in the script is made to search products that are accessories.
	 * When they are found, if the accessory has the same brand, model or name as the search made by the user, they are added to a list.
	 * @return a list of accessories
	 * @author Jago
	 */
	@Override
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		try {
			connection.openConnection();
			
			ctmt = con.prepareCall("{CALL select_accessory()}");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if (rs.getString("name").equals(search) || rs.getString("brand").equals(search) || rs.getString("model").equals(search)) {			
					prod = new Accessory();
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getFloat("salePercentage"));

					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassAccessory enumClassAcc = EnumClassAccessory.valueOf(rs.getString("classAccessory"));
					((Accessory) prod).setClassAccessory(enumClassAcc);

					EnumTypeAccessory enumTypeAcc = EnumTypeAccessory.valueOf(rs.getString("typeAccessory"));
					((Accessory) prod).setTypeAccessory(enumTypeAcc);
				
					listaProductos.add(prod);	
				}	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				connection.closeConnection(stmt, con, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return listaProductos;
	}
	/**
	 * 	TODO For manager
	 * Method for the search of products filtered by id
	 * In the parameter list of products, the method searches the one thats equal to the id
	 * @return a list of products
	 * @author Jago
	 */
	@Override
	public Product searchProductById(int pId, Set<Product> listaProd) {
		Product pAux = null;
		
		for (Product prod : listaProd) {
			if (prod.getIdProduct() == pId) {
				pAux = prod;
			}
		}
		
		return pAux;	
	}
	
	/**
	 * Method for the search of products filtered by name
	 * In the parameter list of products, the method searches those that equal to the name
	 * @return a list of products
	 * @author Jago
	 */
	@Override
	public Set<Product> searchProductByName(String name, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();
		
		for (Product prod : listaProd) {
			if (prod.getNameP().equals(name)) {
				listaFiltr.add(prod);
			}
		}
		
		return listaFiltr;	
	}

	/**
	 * Method for the search of products filtered by brand
	 * In the parameter list of products, the method searches those that equal to the name
	 * @return a list of products
	 * @author Jago
	 */
	@Override
	public Set<Product> searchProductByBrand(String brand, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();

		for (Product prod : listaProd) {
			if (prod.getBrand().equals(brand)) {
				listaFiltr.add(prod);
			}
		}

		return listaFiltr;
	}
	
	/**
	 * Method for the search of products filtered by model
	 * In the parameter list of products, the method searches those that equal to the name
	 * @return a list of products
	 * @author Jago
	 */
	@Override
	public Set<Product> searchProductByModel(String model, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();

		for (Product prod : listaProd) {
			if (prod.getModel().equals(model)) {
				listaFiltr.add(prod);
			}
		}

		return listaFiltr;
	}
	/**
	 * The method searches in the list already provided by a previous search to match the Type of Product selected.
	 * It iterates the list and checks the type of object of the Products. Once it is inside it transforms the String type value to an enum and if its equal
	 * type is the filter referring to the type of product (Acoustic or Electric)
	 * listaProd is the list of products already searched
	 * @author Jago
	 */
	@Override
	public Set<Product> searchProductByType(String type, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();
		
		for (Product prod : listaProd) {
			if (prod instanceof Instrument) {
				EnumTypeInstrument enumType = EnumTypeInstrument.valueOf(type);
				if(((Instrument) prod).getTypeInstrument().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Component) {
				EnumTypeComponent enumType = EnumTypeComponent.valueOf(type);
				if (((Component) prod).getTypeComponent().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Accessory) {
				EnumTypeAccessory enumType = EnumTypeAccessory.valueOf(type);
				if (((Accessory) prod).getTypeAccessory().equals(enumType)) {
					listaFiltr.add(prod);
				}
			}
		}

		return listaFiltr;
	}
	
	/**
	 * The method searches in the list already provided by a previous search to match the Class of Product selected.
	 * It iterates the list and checks the class of object of the Products. Once it is inside it transforms the String class value to an enum and if its equal
	 * type is the filter referring to the type of product (Acoustic or Electric)
	 * listaProd is the list of products already searched
	 * @author Jago
	 */
	@Override
	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();
		
		for (Product prod : listaProd) {
			if (prod instanceof Instrument) {
				EnumClassInstrument enumType = EnumClassInstrument.valueOf(classP);
				if(((Instrument) prod).getClassInstrument().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Component) {
				EnumClassComponent enumType = EnumClassComponent.valueOf(classP);
				if (((Component) prod).getClassComponent().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Accessory) {
				EnumClassAccessory enumType = EnumClassAccessory.valueOf(classP);
				if (((Accessory) prod).getClassAccessory().equals(enumType)) {
					listaFiltr.add(prod);
				}
			}
		}

		return listaFiltr;
	}
	/**
	 * This method checks if there is stock and returns a boolean
	 * @param Product p is the product the user selected
	 * @author Jago
	 */
	@Override
	public boolean checkProduct(Product p) throws Exception {
		boolean stockNotFound = false;
		if (p.getStock() <= 0) {
			stockNotFound = true;
		}
		//TODO StockNotFoundException?
		return stockNotFound;
	}
	
	/**
	 * This method checks within the database to see if the selected product exists
	 * TODO Move to ProductManager, its only useful there
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

	@Override
	public Purchase addPurchase(Product p, Member me) {
		
		return null;
	
	}
	
	@Override
	public Purchase addProduct(Purchase pTotal, Product p, Member m) {
		
		if (pTotal == null) {
			pTotal = new Purchase();
			try {
			con = connection.openConnection();
			
			ctmt = con.prepareCall("{CALL insert_new_purchase(?,?,?,?,?)}");
			
			ctmt.setInt(1, m.getIdUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		pTotal.getSetProduct().add(p);
		return pTotal;
	}

	@Override
	public Purchase listPurchase(Purchase pTotal) {
		for (Product p : pTotal.getSetProduct()) {
			
		}
		
	}

	@Override
	public Purchase removeProduct(Purchase pTotal, Product p) throws Exception {
		ArrayList<Product> pAux = new ArrayList<Product>();
		if (pTotal == null) {
			throw new PurchaseNotFoundException();
		}
		for (Product prod : pTotal.getSetProduct())
			if (!prod.equals(p)) {
				pAux.add(prod);
			}
			
		return pTotal;
	}

	@Override
	public Purchase removePurchase(Purchase pTotal) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

