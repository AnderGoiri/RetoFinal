package logicTier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exceptions.AccessoryNotFoundException;
import exceptions.ComponentNotFoundException;
import exceptions.InstrumentNotFoundException;
import exceptions.ProductNotFoundException;
import exceptions.StockNotFoundException;
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
	 * TODO Maybe let the user type something more than one word that equals any of these (name or model or brand),
	 * a complex search with more than one attribute
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.closeConnection(ctmt, con, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	 * TODO Maybe let the user type something more than one word that equals any of these (name or model or brand),
	 * a complex search with more than one attribute
	 * @author Jago
	 */
	@Override
	public Set<Product> searchComponent(String search){
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		try {
			connection.openConnection();
			
			//ctmt = con.prepareStatement();
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
	 * TODO Maybe let the user type something more than one word that equals any of these (name or model or brand),
	 * a complex search with more than one attribute
	 * @author Jago
	 */
	@Override
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		try {
			connection.openConnection();
			
			//stmt = con.prepareStatement(SELECTcomp);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.closeConnection(stmt, con, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaProductos;
	}
	/**
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
	 * @param
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
	 * @param
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
		return stockNotFound;
	}
	
	/**
	 * This method checks within the database to see if the selected product exists
	 * TODO Move to ProductManager, its only useful there
	 * @author Jago
	 */
	@Override
	public boolean existsProduct(Product p) {
		ResultSet rs = null;
		boolean existe = false;

		try {
			con = connection.openConnection();
			ctmt = con.prepareCall("{CALL select_instrument()}");
			rs = ctmt.executeQuery();

			while (rs.next() && !existe) {
				if (rs.getInt("idProduct") == (p.getIdProduct())) {
					existe = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public Purchase addPurchase(Member me) {
		Purchase p = new Purchase();
		Set<Product> purchaseSet = new HashSet<Product>();
		
		
		
		return p;
	}
	
	@Override
	public Purchase addProduct(Purchase pset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listPurchase(Purchase pset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Purchase removeProduct(Purchase pset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase removePurchase(Purchase pset) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

