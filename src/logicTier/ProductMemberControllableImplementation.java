package logicTier;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import exceptions.ProductNotFoundException;
import exceptions.PurchaseNotFoundException;
import exceptions.StockNotFoundException;
import model.Accessory;
import model.Component;
import model.EnumClassAccessory;
import model.EnumClassComponent;
import model.EnumClassInstrument;
import model.EnumStatusPurchase;
import model.EnumTypeAccessory;
import model.EnumTypeComponent;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Member;
import model.Product;
import model.Purchase;

/**
 * This class implements the ProductMemberControllable interface and provides
 * methods for searching products that are instruments or components. It
 * interacts with a database to retrieve the product information.
 * 
 * @author Jagoba Bartolomé Barroso
 */
public class ProductMemberControllableImplementation implements ProductMemberControllable {
	// --- DB Connection ---
	private Connection con;
	private PreparedStatement stmt;
	private CallableStatement ctmt;
	private GateDB connection = new GateDB();

	// --- Attributes ---
	private Product prod;
	private Purchase purch;

	/**
	 * Method for the search of products that are instruments A call for a procedure
	 * in the script is made to search products that are instruments. When they are
	 * found, if the instrument has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
	 * @return a list of instruments
	 * @author Jagoba Bartolomé Barroso
	 */
	@Override
	public Set<Product> searchInstrument(String search) throws SQLException {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		con = connection.openConnection();

		ctmt = con.prepareCall("{CALL select_instrument()}");
		rs = ctmt.executeQuery();

		while (rs.next()) {
			if (rs.getBoolean("isActive") == true) {
				if (!search.equals("")) {
					if (rs.getString("name").contains(search) || rs.getString("brand").contains(search)
							|| rs.getString("model").contains(search) || rs.getString("color").contains(search)) {
						prod = new Instrument();
						prod.setIdProduct(rs.getInt("idProduct"));
						prod.setNameP(rs.getString("name"));
						prod.setPrice(rs.getFloat("unitPrice"));
						prod.setDescriptionP(rs.getString("description"));
						prod.setStock(rs.getInt("stock"));
						prod.setBrand(rs.getString("brand"));
						prod.setModel(rs.getString("model"));
						prod.setColor(rs.getString("color"));
						prod.setActive(rs.getBoolean("isActive"));
						prod.setSaleActive(rs.getBoolean("saleActive"));
						prod.setSalePercentage(rs.getInt("salePercentage"));
						/**
						 * Transformation of enum to String as JDBC doesn't support enums
						 */
						EnumClassInstrument enumClassInstr = EnumClassInstrument
								.getValue(rs.getString("classInstrument"));
						((Instrument) prod).setClassInstrument(enumClassInstr);

						EnumTypeInstrument enumTypeInstr = EnumTypeInstrument.getValue(rs.getString("typeInstrument"));
						((Instrument) prod).setTypeInstrument(enumTypeInstr);

						listaProductos.add(prod);
					}
				} else {
					prod = new Instrument();
					prod.setIdProduct(rs.getInt("idProduct"));
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getInt("salePercentage"));
					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassInstrument enumClassInstr = EnumClassInstrument.getValue(rs.getString("classInstrument"));
					((Instrument) prod).setClassInstrument(enumClassInstr);

					EnumTypeInstrument enumTypeInstr = EnumTypeInstrument.getValue(rs.getString("typeInstrument"));
					((Instrument) prod).setTypeInstrument(enumTypeInstr);

					listaProductos.add(prod);
				}

			}
		}
		connection.closeConnection(ctmt, con);
		return listaProductos;
	}

	/**
	 * Method for the search of products that are components A call for a procedure
	 * in the script is made to search products that are components. When they are
	 * found, if the component has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
	 * @return a list of components
	 * @author Jagoba Bartolomé Barroso
	 */
	@Override
	public Set<Product> searchComponent(String search) throws SQLException {
		Set<Product> listaProductos = new HashSet<Product>();
		ResultSet rs = null;

		con = connection.openConnection();

		ctmt = con.prepareCall("{CALL select_component()}");
		rs = ctmt.executeQuery();

		while (rs.next()) {
			if (rs.getBoolean("isActive") == true) {
				if (!search.equals("")) {
					if (rs.getString("name").contains(search) || rs.getString("brand").contains(search)
							|| rs.getString("model").contains(search) || rs.getString("color").contains(search)) {
						prod = new Component();
						prod.setIdProduct(rs.getInt("idProduct"));
						prod.setNameP(rs.getString("name"));
						prod.setPrice(rs.getFloat("unitPrice"));
						prod.setDescriptionP(rs.getString("description"));
						prod.setStock(rs.getInt("stock"));
						prod.setBrand(rs.getString("brand"));
						prod.setModel(rs.getString("model"));
						prod.setColor(rs.getString("color"));
						prod.setActive(rs.getBoolean("isActive"));
						prod.setSaleActive(rs.getBoolean("saleActive"));
						prod.setSalePercentage(rs.getInt("salePercentage"));

						/**
						 * Transformation of enum to String as JDBC doesn't support enums
						 */
						EnumClassComponent enumClassComp = EnumClassComponent.getValue(rs.getString("classComponent"));
						((Component) prod).setClassComponent(enumClassComp);

						EnumTypeComponent enumTypeComp = EnumTypeComponent.getValue(rs.getString("typeComponent"));
						((Component) prod).setTypeComponent(enumTypeComp);

						listaProductos.add(prod);
					}
				} else {
					prod = new Component();
					prod.setIdProduct(rs.getInt("idProduct"));
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getInt("salePercentage"));

					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassComponent enumClassComp = EnumClassComponent.getValue(rs.getString("classComponent"));
					((Component) prod).setClassComponent(enumClassComp);

					EnumTypeComponent enumTypeComp = EnumTypeComponent.getValue(rs.getString("typeComponent"));
					((Component) prod).setTypeComponent(enumTypeComp);

					listaProductos.add(prod);
				}

			}
		}
		connection.closeConnection(ctmt, con);
		return listaProductos;
	}

	/**
	 * Method for the search of products that are accessories A call for a procedure
	 * in the script is made to search products that are accessories. When they are
	 * found, if the accessory has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
	 * @return a list of accessories
	 * @author Jago
	 * @throws SQLException
	 */
	@Override
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException, SQLException {
		Set<Product> listaProductos = new HashSet<Product>();
		ResultSet rs = null;

		con = connection.openConnection();
		ctmt = con.prepareCall("{CALL select_accessory()}");
		rs = ctmt.executeQuery();
		if (!rs.next()) {
			throw new ProductNotFoundException(
					"The requested product could not be found. Please check the product details and try again or contact customer support for further assistance.");
		}
		while (rs.next()) {
			if (rs.getBoolean("isActive") == true) {
				if (!search.equals("")) {
					if (rs.getString("name").contains(search) || rs.getString("brand").contains(search)
							|| rs.getString("model").contains(search) || rs.getString("color").contains(search)) {
						prod = new Accessory();
						prod.setIdProduct(rs.getInt("idProduct"));
						prod.setNameP(rs.getString("name"));
						prod.setPrice(rs.getFloat("unitPrice"));
						prod.setDescriptionP(rs.getString("description"));
						prod.setStock(rs.getInt("stock"));
						prod.setBrand(rs.getString("brand"));
						prod.setModel(rs.getString("model"));
						prod.setColor(rs.getString("color"));
						prod.setActive(rs.getBoolean("isActive"));
						prod.setSaleActive(rs.getBoolean("saleActive"));
						prod.setSalePercentage(rs.getInt("salePercentage"));

						/**
						 * Transformation of enum to String as JDBC doesn't support enums
						 */
						EnumClassAccessory enumClassAcc = EnumClassAccessory.getValue(rs.getString("classAccessory"));
						((Accessory) prod).setClassAccessory(enumClassAcc);

						EnumTypeAccessory enumTypeAcc = EnumTypeAccessory.getValue(rs.getString("typeAccessory"));
						((Accessory) prod).setTypeAccessory(enumTypeAcc);

						listaProductos.add(prod);
					}
				} else {
					prod = new Accessory();
					prod.setIdProduct(rs.getInt("idProduct"));
					prod.setNameP(rs.getString("name"));
					prod.setPrice(rs.getFloat("unitPrice"));
					prod.setDescriptionP(rs.getString("description"));
					prod.setStock(rs.getInt("stock"));
					prod.setBrand(rs.getString("brand"));
					prod.setModel(rs.getString("model"));
					prod.setColor(rs.getString("color"));
					prod.setActive(rs.getBoolean("isActive"));
					prod.setSaleActive(rs.getBoolean("saleActive"));
					prod.setSalePercentage(rs.getInt("salePercentage"));

					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassAccessory enumClassAcc = EnumClassAccessory.getValue(rs.getString("classAccessory"));
					((Accessory) prod).setClassAccessory(enumClassAcc);

					EnumTypeAccessory enumTypeAcc = EnumTypeAccessory.getValue(rs.getString("typeAccessory"));
					((Accessory) prod).setTypeAccessory(enumTypeAcc);

					listaProductos.add(prod);
				}

			}
			connection.closeConnection(ctmt, con);
		}
		return listaProductos;
	}

	/**
	 * Method for the search of products filtered by name In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
	 * @return a list of products
	 * @author Jagoba Bartolomé Barroso
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
	 * Method for the search of products filtered by brand In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
	 * @return a list of products
	 * @author Jagoba Bartolomé Barroso
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
	 * Method for the search of products filtered by model In the parameter list of
	 * products, the method searches those that equal to the name
	 * 
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
	 * The method searches in the list already provided by a previous search to
	 * match the Type of Product selected. It iterates the list and checks the type
	 * of object of the Products. Once it is inside it transforms the String type
	 * value to an enum and if its equal type is the filter referring to the type of
	 * product (Acoustic or Electric) listaProd is the list of products already
	 * searched
	 * 
	 * @author Jagoba Bartolomé Barroso
	 */
	@Override
	public Set<Product> searchProductByType(String type, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();

		for (Product prod : listaProd) {
			if (prod instanceof Instrument) {
				EnumTypeInstrument enumType = EnumTypeInstrument.getValue(type);
				if (((Instrument) prod).getTypeInstrument().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Component) {
				EnumTypeComponent enumType = EnumTypeComponent.getValue(type);
				if (((Component) prod).getTypeComponent().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Accessory) {
				EnumTypeAccessory enumType = EnumTypeAccessory.getValue(type);
				if (((Accessory) prod).getTypeAccessory().equals(enumType)) {
					listaFiltr.add(prod);
				}
			}
		}
		return listaFiltr;
	}

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
	@Override
	public Set<Product> searchProductByClass(String classP, Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();

		for (Product prod : listaProd) {
			if (prod instanceof Instrument) {
				EnumClassInstrument enumType = EnumClassInstrument.getValue(classP);
				if (((Instrument) prod).getClassInstrument().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Component) {
				EnumClassComponent enumType = EnumClassComponent.getValue(classP);
				if (((Component) prod).getClassComponent().equals(enumType)) {
					listaFiltr.add(prod);
				}
			} else if (prod instanceof Accessory) {
				EnumClassAccessory enumType = EnumClassAccessory.getValue(classP);
				if (((Accessory) prod).getClassAccessory().equals(enumType)) {
					listaFiltr.add(prod);
				}
			}
		}
		return listaFiltr;
	}

	/**
	 * This method searches in a product list for products with any sale
	 * 
	 * @return Set<Product>
	 * @author Jagoba Bartolomé Barroso
	 */
	public Set<Product> searchProductInSale(Set<Product> listaProd) {
		Set<Product> listaFiltr = new HashSet<Product>();

		for (Product prod : listaProd) {
			if (prod.isActive() && prod.isSaleActive()) {
				listaFiltr.add(prod);
			}
		}

		return listaFiltr;

	}

	/**
	 * This method checks if there is stock and returns a boolean
	 * 
	 * @param Product p is the product the user selected
	 * @author Jagoba Bartolomé Barroso
	 */
	@Override
	public boolean checkProduct(Product p) {
		boolean stockNotFound = false;
		if (p.getStock() <= 0) {
			stockNotFound = true;
		}
		return stockNotFound;
	}

	/**
	 * First we transform a String value into enum. We check if the product has
	 * stock (bool StockNotFound false) and then update the product table. Then we
	 * check if the current Purchase is new (to add it as a new one into the
	 * database) and if the status is NOT "In progress", Then we add a new purchase
	 * into the database and we retrieve the info we just inserted to use it here.
	 * In case the Purchase is not null, we update the Purchase with new info of the
	 * product. We update the purchase record of the member with a new one
	 * 
	 * @param Purchase pTotal is the Purchase currently in progress, Product p is
	 *                 the product we want to add to the shopping cart and Member m
	 *                 the member using the application.
	 * @author Jago Bartolomé Barroso
	 * @throws SQLException
	 * @throws ProductNotFoundException
	 * @throws StockNotFoundException
	 */
	@Override
	public Purchase addProductPurchase(Purchase pTotal, Product p, Member m)
			throws SQLException, ProductNotFoundException, StockNotFoundException {
		String stPurch = "In progress";
		EnumStatusPurchase statusPurch = EnumStatusPurchase.getValue(stPurch);
		con = connection.openConnection();

		if (p.isActive() == true) {
			if (!checkProduct(p)) {
				pTotal.getSetProduct().add(p);
				ctmt = con.prepareCall("UPDATE product SET stock=? WHERE idProduct=?");
				ctmt.setInt(1, p.setStock((int) (p.getStock() - 1f)));
				ctmt.setInt(2, p.getIdProduct());

				ctmt.executeUpdate();

				if ((pTotal == null) || (!pTotal.getStatusPurchase().equals(statusPurch))) {
					pTotal = new Purchase();
					ctmt = con.prepareCall("{CALL insert_new_purchase(?,?,?,?,?)}");

					ctmt.setInt(1, m.getIdUser());
					ctmt.setInt(2, 1);
					ctmt.setInt(3, 1);
					ctmt.setFloat(4, p.getPrice());
					ctmt.setString(5, "In progress");

					ctmt.executeUpdate();

					// Obtener el idPurchase generado por la base de datos
					ResultSet rs = ctmt.getGeneratedKeys();
					if (rs.next()) {
						int idPurchase = rs.getInt(1);
						float price = rs.getFloat(2);
						EnumStatusPurchase enumStPurchase = EnumStatusPurchase.getValue(rs.getString("statusPurchase"));
						LocalDate date = LocalDate.parse(rs.getString("datePurchase"));
						int purchaseQ = 1;
						pTotal.setIdPurchase(idPurchase);
						pTotal.setPurchaseTotalCost(price);
						pTotal.setStatusPurchase(enumStPurchase);
						pTotal.setPurchaseDate(date);
						pTotal.setPurchaseQuantity(purchaseQ);
					}
					Set<Purchase> listPurchase = m.getPurchaseRecord();
					listPurchase.add(pTotal);
					m.setPurchaseRecord(listPurchase);

				} else {
					// If pTotal is not null, there's already a purchase in progress that we need to
					// update

					ctmt = con.prepareCall("UPDATE purchase SET purchaseQuantity=?, totalPrice=?  WHERE idPurchase=?");
					ctmt.setInt(1, pTotal.getPurchaseQuantity() + 1);
					ctmt.setFloat(2, pTotal.getPurchaseTotalCost() + p.getPrice());
					ctmt.setInt(3, pTotal.getIdPurchase());

					ctmt.executeUpdate();

					// Actualizar pTotal con los nuevos datos de la compra
					pTotal.setPurchaseTotalCost(pTotal.getPurchaseTotalCost() + p.getPrice());
					pTotal.setPurchaseQuantity(pTotal.getPurchaseQuantity() + 1);

				}
			} else {
				throw new StockNotFoundException(
						"The stock for the specified product could not be found. Please check the product details and try again or contact the administrator for assistance.");
			}
		} else {
			throw new ProductNotFoundException(
					"The requested product could not be found. Please check the product details and try again or contact customer support for further assistance.");
		}
		connection.closeConnection(ctmt, con);
		return pTotal;
	}

	/**
	 * This method returns the current "In progress" purchase from the member
	 * purchase record
	 * 
	 * @param Member m
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase searchPurchase(Member m) {
		Set<Purchase> listPurchase = m.getPurchaseRecord();
		Purchase aux = null;

		for (Purchase p : listPurchase) {
			String stPurch = "In progress";

			EnumStatusPurchase statusPurch = EnumStatusPurchase.getValue(stPurch);

			if (p.getStatusPurchase().equals(statusPurch)) {
				aux = p;
			}
		}
		return aux;
	}

	/**
	 * This method first checks if the Purchase pTotal is null, if not, then there
	 * is at least one product inside. If there are products inside, we loop through
	 * each one and save them in a secondary Set of Products, once this is done, the
	 * new Set is saved in the Purchase pTotal, and the Purchase cost and quantity
	 * are updated. Finally we update the information in the database.
	 * 
	 * @param Purchase pTotal is the current Purchase in progress, Product p is the
	 *                 product that we wish to remove from the purchase
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase removeProduct(Purchase pTotal, Product p) throws Exception {
		Set<Product> pAux = new HashSet<Product>();
		con = connection.openConnection();
		if (pTotal == null) {
			throw new PurchaseNotFoundException(
					"The requested purchase could not be found. Please check the purchase details and try again or contact customer support for further assistance.");
		} else {
			for (Product prod : pTotal.getSetProduct()) {
				if (!prod.equals(p)) {
					pAux.add(prod);
				}
			}
			pTotal.setSetProduct(pAux);
			pTotal.setPurchaseTotalCost(pTotal.getPurchaseTotalCost() - p.getPrice());
			pTotal.setPurchaseQuantity(pTotal.getPurchaseQuantity() - 1);
			ctmt = con.prepareCall("UPDATE purchase SET purchaseQuantity=?, totalPrice=?  WHERE idPurchase=?");
			ctmt.setInt(1, pTotal.getPurchaseQuantity() - 1);
			ctmt.setFloat(2, pTotal.getPurchaseTotalCost() - p.getPrice());
			ctmt.setInt(3, pTotal.getIdPurchase());
			ctmt.executeUpdate();

		}
		connection.closeConnection(ctmt, con);
		return pTotal;

	}

	/**
	 * This method checks if the pTotal status is "In progress" and if that's the
	 * case, the value is changed to "Finished". This method will be called when
	 * finishing shopping.
	 * 
	 * @param Purchase pTotal
	 * @author Jago Bartolomé Barroso
	 * @throws PurchaseNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Purchase removePurchase(Purchase pTotal) throws PurchaseNotFoundException, SQLException {
		String stPurch = "In progress";
		con = connection.openConnection();
		EnumStatusPurchase statusPurch = EnumStatusPurchase.getValue(stPurch);

		if (pTotal.getStatusPurchase().equals(statusPurch)) {
			stPurch = "Finished";
			statusPurch = EnumStatusPurchase.getValue(stPurch);
			pTotal.setStatusPurchase(statusPurch);
			ctmt = con.prepareCall("UPDATE purchase SET purchaseStatus=?");
			ctmt.setString(1, stPurch);

		} else {
			throw new PurchaseNotFoundException(
					"The requested purchase could not be found. Please check the purchase details and try again or contact customer support for further assistance.");
		}
		connection.closeConnection(ctmt, con);
		return pTotal;
	}

	/**
	 * This method changes the member's info in the database
	 * 
	 * @param Member m is the current logged-in member with the attributes already
	 *               changed
	 * @author Jago
	 * @throws SQLException
	 */
	@Override
	public void modifyMember(Member m, String username) throws SQLException {
		con = connection.openConnection();
		ResultSet rs = null;

		stmt = con.prepareStatement("UPDATE user SET username=?, name=?, surname=?, mail=? WHERE username= ?");
		stmt.setString(1, m.getUserName());
		stmt.setString(2, m.getName());
		stmt.setString(3, m.getSurname());
		stmt.setString(4, m.getMail());
		stmt.setString(5, username);
		stmt.executeUpdate();

		stmt = con.prepareStatement("SELECT * from user where username = " + m.getUserName());
		rs = stmt.executeQuery();
		int idU = rs.getInt("idUser");

		stmt = con.prepareStatement("UPDATE member m SET address=?, creditCard=? WHERE idUser = ?");
		stmt.setString(1, m.getAddress());
		stmt.setString(2, m.getCreditCard());
		stmt.setInt(3, idU);

		stmt.executeUpdate();
		connection.closeConnection(stmt, con);
	}

	/**
	 * Method to get the list of Purchases of a Member
	 * 
	 * @param Member m because we need the id of the member
	 * @throws PurchaseNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Set<Purchase> getListPurchase(Member m) throws PurchaseNotFoundException, SQLException {
		Set<Purchase> listaPurchase = new HashSet<Purchase>();
		ResultSet rs = null;
		con = connection.openConnection();

		stmt = con.prepareStatement("select * from purchase where idUser=?");
		stmt.setInt(1, m.getIdUser());
		rs = stmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {

				purch.setIdUser(rs.getInt("idUser"));

				LocalDate date = LocalDate.parse(rs.getString("datePurchase"));
				purch.setPurchaseDate(date);

				purch.setPurchaseTotalCost(rs.getFloat("totalPrice"));
				purch.setPurchaseQuantity(rs.getInt("purchaseQuantity"));

				EnumStatusPurchase statusPurch = EnumStatusPurchase.getValue(rs.getString("purchaseStatus"));
				purch.setStatusPurchase(statusPurch);

				listaPurchase.add(purch);
			}
		} else {
			throw new PurchaseNotFoundException(
					"The requested purchase could not be found. Please check the purchase details and try again or contact customer support for further assistance.");
		}
		connection.closeConnection(stmt, con);
		return listaPurchase;
	}

	/**
	 * Retrieves the type of product based on the given product ID.
	 *
	 * @param idProduct The ID of the product.
	 * @return A character representing the type of product: - 'I' for Instrument -
	 *         'C' for Component - 'A' for Accessory - 'U' for Unknown (product not
	 *         found in any table)
	 * @throws SQLException if a database access error occurs.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Override
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
		connection.closeConnection(stmtInstrument, con);
		connection.closeConnection(stmtComponent, con);
		connection.closeConnection(stmtAccessory, con);
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
	public Set<Product> getAllProducts(String search) throws SQLException {
		ResultSet rs = null;
		con = connection.openConnection();
		ctmt = con.prepareCall("{CALL select_all_products}");
		rs = ctmt.executeQuery();

		Set<Product> setProducts = new HashSet<Product>();

		while (rs.next()) {
			if (rs.getBoolean("isActive") == true) {
				if (!search.equals("")) {
					if (rs.getString("name").contains(search) || rs.getString("brand").contains(search)
							|| rs.getString("model").contains(search) || rs.getString("color").contains(search)) {
						int idProduct = rs.getInt("idProduct");
						String name = rs.getString("name");
						float unitPrice = rs.getInt("unitPrice");
						String description = rs.getString("description");
						int stock = rs.getInt("stock");
						String brand = rs.getString("brand");
						String model = rs.getString("model");
						String color = rs.getString("color");
						boolean saleActive = rs.getBoolean("saleActive");
						int salePercentage = rs.getInt("salePercentage");
						boolean isActive = rs.getBoolean("isActive");

						if (getTypeProduct(idProduct) == 'I') { // check if the value f in the instrument table
							EnumClassInstrument classInstrument = EnumClassInstrument.getValue(rs.getString(12));
							EnumTypeInstrument typeInstrument = EnumTypeInstrument.getValue(rs.getString(13));

							Instrument instrument = new Instrument(idProduct, name, unitPrice, description, stock,
									brand, model, color, saleActive, salePercentage, isActive, classInstrument,
									typeInstrument);

							setProducts.add(instrument);

						} else if (getTypeProduct(idProduct) == 'C') { // check if the value exists in the component
																		// table
							EnumClassComponent classComponent = EnumClassComponent.getValue(rs.getString(12));

							EnumTypeComponent typeComponent = EnumTypeComponent.getValue(rs.getString(13));

							Component component = new Component(idProduct, name, unitPrice, description, stock, brand,
									model, color, saleActive, salePercentage, isActive, classComponent, typeComponent);

							setProducts.add(component);

						} else if (getTypeProduct(idProduct) == 'A') { // check if the value exists in the accessory
																		// table
							EnumClassAccessory classAccessory = EnumClassAccessory.getValue(rs.getString(12));

							EnumTypeAccessory typeAccessory = EnumTypeAccessory.getValue(rs.getString(13));

							Accessory accessory = new Accessory(idProduct, name, unitPrice, description, stock, brand,
									model, color, saleActive, salePercentage, isActive, classAccessory, typeAccessory);

							setProducts.add(accessory);
						}
					}
				} else {
					int idProduct = rs.getInt("idProduct");
					String name = rs.getString("name");
					float unitPrice = rs.getInt("unitPrice");
					String description = rs.getString("description");
					int stock = rs.getInt("stock");
					String brand = rs.getString("brand");
					String model = rs.getString("model");
					String color = rs.getString("color");
					boolean saleActive = rs.getBoolean("saleActive");
					int salePercentage = rs.getInt("salePercentage");
					boolean isActive = rs.getBoolean("isActive");

					if (getTypeProduct(idProduct) == 'I') { // check if the value exists in the instrument table
						EnumClassInstrument classInstrument = EnumClassInstrument.getValue(rs.getString(12));
						EnumTypeInstrument typeInstrument = EnumTypeInstrument.getValue(rs.getString(13));

						Instrument instrument = new Instrument(idProduct, name, unitPrice, description, stock, brand,
								model, color, saleActive, salePercentage, isActive, classInstrument, typeInstrument);

						setProducts.add(instrument);

					} else if (getTypeProduct(idProduct) == 'C') { // check if the value exists in the component
																	// table
						EnumClassComponent classComponent = EnumClassComponent.getValue(rs.getString(12));

						EnumTypeComponent typeComponent = EnumTypeComponent.getValue(rs.getString(13));

						Component component = new Component(idProduct, name, unitPrice, description, stock, brand,
								model, color, saleActive, salePercentage, isActive, classComponent, typeComponent);

						setProducts.add(component);

					} else if (getTypeProduct(idProduct) == 'A') { // check if the value exists in the accessory
																	// table
						EnumClassAccessory classAccessory = EnumClassAccessory.getValue(rs.getString(12));

						EnumTypeAccessory typeAccessory = EnumTypeAccessory.getValue(rs.getString(13));

						Accessory accessory = new Accessory(idProduct, name, unitPrice, description, stock, brand,
								model, color, saleActive, salePercentage, isActive, classAccessory, typeAccessory);

						setProducts.add(accessory);
					}
				}
			}
		}
		connection.closeConnection(ctmt, con);
		return setProducts;
	}

	/**
	 * Method for the search of products filtered by id In the parameter list of
	 * products, the method searches the one thats equal to the id
	 * 
	 * @param int pId is the id of the product we want to search, listaProd is the
	 *            list of all products
	 * @return a list of products
	 * @throws ProductNotFoundException if it doesn't exist
	 * @author Jago
	 */
	@Override
	public Product searchProductById(int pId, Set<Product> listaProd) throws ProductNotFoundException {
		Product pAux = null;
		for (Product prod : listaProd) {
			if (prod.getIdProduct() == pId) {
				pAux = prod;
			}
		}
		if (pAux != null) {

		} else {
			throw new ProductNotFoundException(
					"The requested product could not be found. Please check the product details and try again or contact customer support for further assistance.");
		}
		return pAux;
	}
}
