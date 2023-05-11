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


public class ProductMemberControllableImplementation implements ProductMemberControllable {
	//DB Connection
	private Connection con;
	private PreparedStatement stmt;
	private CallableStatement ctmt;
	private GateDB connection = new GateDB();
	
	// Attributes
	private Product prod;
 
	// Sentencias SQL

	/**
	 * Method for the search of products that are instruments A call for a procedure
	 * in the script is made to search products that are instruments. When they are
	 * found, if the instrument has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
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

			while (rs.next()) {
				if (rs.getBoolean("isActive") == true) {
					if (rs.getString("name").equals(search) || rs.getString("brand").equals(search)
							|| rs.getString("model").equals(search)) {
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
						prod.setSalePercentage(rs.getInt("salePercentage"));
						System.out.println(prod.toString());
						/**
						 * Transformation of enum to String as JDBC doesn't support enums
						 */
						EnumClassInstrument enumClassInstr = EnumClassInstrument
								.valueOf(rs.getString("classInstrument"));
						((Instrument) prod).setClassInstrument(enumClassInstr);

						EnumTypeInstrument enumTypeInstr = EnumTypeInstrument.valueOf(rs.getString("typeInstrument"));
						((Instrument) prod).setTypeInstrument(enumTypeInstr);

						listaProductos.add(prod);
					}
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
	 * Method for the search of products that are components A call for a procedure
	 * in the script is made to search products that are components. When they are
	 * found, if the component has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
	 * @return a list of components
	 * @author Jago
	 */
	@Override
	public Set<Product> searchComponent(String search) {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();

		try {
			connection.openConnection();

			ctmt = con.prepareCall("{CALL select_component()}");
			rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean("isActive") == true) {
					if (rs.getString("name").equals(search) || rs.getString("brand").equals(search)
							|| rs.getString("model").equals(search)) {
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
						prod.setSalePercentage(rs.getInt("salePercentage"));

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
	 * Method for the search of products that are accessories A call for a procedure
	 * in the script is made to search products that are accessories. When they are
	 * found, if the accessory has the same brand, model or name as the search made
	 * by the user, they are added to a list.
	 * 
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

			while (rs.next()) {
				if (rs.getBoolean("isActive") == true) {
					if (rs.getString("name").equals(search) || rs.getString("brand").equals(search)
							|| rs.getString("model").equals(search)) {
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
						prod.setSalePercentage(rs.getInt("salePercentage"));

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
	 * This method searches in a product list for products with any sale
	 */
	public Set<Product> searchProductInSale(Set<Product> listaProd){
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
	 * @param Product p is the product the user selected
	 * @author Jago
	 * TODO Exception
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

	/**
	 * First we transform a String value into enum. We check if the product has
	 * stock and then update the product table. Then we check if the current
	 * Purchase is new (to add it as a new one into the database) and if the status
	 * is NOT "In progress", Then we add a new purchase into the database and we
	 * retrieve the info we just inserted to use it here. In case the Purchase is
	 * not null, we update the Purchase with new info of the product. We update the
	 * purchase record of the member with a new one
	 * 
	 * @param Purchase pTotal is the Purchase currently in progress, Product p is
	 *                 the product we want to add to the shopping cart and Member m
	 *                 the member using the application.
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase addProductPurchase(Purchase pTotal, Product p, Member m)
			throws StockNotFoundException, ProductNotFoundException {
		String stPurch = "In progress";
		EnumStatusPurchase statusPurch = EnumStatusPurchase.valueOf(stPurch);

		try {
			if (existsProduct(p.getIdProduct()) && (p.isActive() == true)) {
				if (checkProduct(p)) {
					pTotal.getSetProduct().add(p);

					con = connection.openConnection();
					ctmt = con.prepareCall("UPDATE product SET stock=? WHERE idProduct=?");
					ctmt.setInt(1, p.setStock((int) (p.getStock() - 1f)));
					ctmt.setInt(2, p.getIdProduct());

					ctmt.executeUpdate();

					if ((pTotal == null) || (!pTotal.getStatusPurchase().equals(statusPurch))) {
						pTotal = new Purchase();
						try {
							con = connection.openConnection();

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
								EnumStatusPurchase enumStPurchase = EnumStatusPurchase
										.valueOf(rs.getString("statusPurchase"));
								LocalDate date = LocalDate.parse(rs.getString("datePurchase"));
								int purchaseQ = 1;
								pTotal.setIdPurchase(idPurchase);
								pTotal.setPurchaseTotalCost(price);
								pTotal.setStatusPurchase(enumStPurchase);
								pTotal.setPurchaseDate(date);
								pTotal.setPurchaseQuantity(purchaseQ);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							try {
								connection.closeConnection(ctmt, con, null);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						try {
							Set<Purchase> listPurchase = m.getPurchaseRecord();
							listPurchase.add(pTotal);
							m.setPurchaseRecord(listPurchase);
							// TODO Check if this is saved correctly (db?)
						} catch (Exception e) {

							e.printStackTrace();
						}
					} else {
						// If pTotal is not null, there's already a purchase in progress that we need to
						// update

						try {
							con = connection.openConnection();
							ctmt = con.prepareCall("UPDATE purchase SET purchaseQuantity=?, totalPrice=?  WHERE idPurchase=?");
							ctmt.setInt(1, pTotal.getPurchaseQuantity() + 1);
							ctmt.setFloat(2, pTotal.getPurchaseTotalCost() + p.getPrice());
							ctmt.setInt(3, pTotal.getIdPurchase());

							ctmt.executeUpdate();

							// Actualizar pTotal con los nuevos datos de la compra
							pTotal.setPurchaseTotalCost(pTotal.getPurchaseTotalCost() + p.getPrice());
							pTotal.setPurchaseQuantity(pTotal.getPurchaseQuantity() + 1);
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							try {
								connection.closeConnection(ctmt, con, null);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}

				} else {
					throw new StockNotFoundException();
				}
			} else {
				throw new ProductNotFoundException();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection.closeConnection(ctmt, con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return pTotal;
	}

	/**
	 * This method returns the current "In progress" purchase from the member purchase record
	 * @param Member m
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase searchPurchase(Member m) {
		Set<Purchase> listPurchase = m.getPurchaseRecord();
		Purchase aux = null;
		
		for (Purchase p : listPurchase) {
			String stPurch = "In progress";
			EnumStatusPurchase statusPurch = EnumStatusPurchase.valueOf(stPurch);
			
			if (p.getStatusPurchase().equals(statusPurch)) {
				aux = p;
			}
		}
		return aux;
	}

	/**
	 * This method first checks if the Purchase pTotal is null, if not, then there is at least one product inside. If there are products inside, we loop through each one and
	 * save them in a secondary Set of Products, once this is done, the new Set is saved in the Purchase pTotal, and the Purchase cost and quantity are updated. Finally we update the information in the database.
	 * @param Purchase pTotal is the current Purchase in progress, Product p is the product that we wish to remove from the purchase
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase removeProduct(Purchase pTotal, Product p) throws Exception {
		Set<Product> pAux = new HashSet<Product>();
		if (pTotal == null) {
			throw new PurchaseNotFoundException();
		} else {
			for (Product prod : pTotal.getSetProduct()) {
				if (!prod.equals(p)) {
					pAux.add(prod);
				}
			}
			pTotal.setSetProduct(pAux);
			pTotal.setPurchaseTotalCost(pTotal.getPurchaseTotalCost() - p.getPrice());
			pTotal.setPurchaseQuantity(pTotal.getPurchaseQuantity() - 1);
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE purchase SET purchaseQuantity=?, totalPrice=?  WHERE idPurchase=?");
				ctmt.setInt(1, pTotal.getPurchaseQuantity() - 1);
				ctmt.setFloat(2, pTotal.getPurchaseTotalCost() - p.getPrice());
				ctmt.setInt(3, pTotal.getIdPurchase());
				ctmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.closeConnection(ctmt, con, null);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}	
		return pTotal;
	}
	/**
	 * This method checks if the pTotal status is "In progress" and if that's the case, the value is changed to "Finished". This method will be called when finishing shopping.
	 * @param Purchase pTotal
	 * @author Jago Bartolomé Barroso
	 */
	@Override
	public Purchase removePurchase(Purchase pTotal) {
		String stPurch = "In progress";
		EnumStatusPurchase statusPurch = EnumStatusPurchase.valueOf(stPurch);
		
		if(pTotal.getStatusPurchase().equals(statusPurch)) {
			stPurch = "Finished";
			statusPurch = EnumStatusPurchase.valueOf(stPurch);
			pTotal.setStatusPurchase(statusPurch);
			
			try {
				con = connection.openConnection();
				ctmt = con.prepareCall("UPDATE purchase SET purchaseStatus=?");
				ctmt.setString(1, stPurch);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.closeConnection();
			}
			
			
			
		}
		return pTotal;
	}
	/**
	 * This method changes the member's info in the database
	 * @param Member m is the current logged-in member with the attributes already changed
	 * @author Jago
	 */
	public void modifyMember(Member m) {
		con = connection.openConnection();
		
		try {
			ctmt = con.prepareCall("UPDATE user SET username=?, name=?, surname=?, mail=?");
			ctmt.setString(1, m.getUserName());
			ctmt.setString(2, m.getName());
			ctmt.setString(3, m.getSurname());
			ctmt.setString(4, m.getMail());
			ctmt.executeQuery();
			
			ctmt = con.prepareCall("UPDATE member SET address=?, creditCard=?, ");
			ctmt.setString(1, m.getAddress());
			ctmt.setString(2, m.getCreditCard());
			
			ctmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
	}

}

