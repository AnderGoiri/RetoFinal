package logicTier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import exceptions.InstrumentNotFoundException;
import exceptions.ProductNotFoundException;
import model.EnumClassInstrument;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Product;

public class ProductMemberControllableImplementation implements ProductMemberControllable {
	//DB Connection
	private Connection con;
	private PreparedStatement stmt;
	private GateDB connection = new GateDB();
	
	//Attributes
	private Product prod = null;
	
	//Sentencias SQL
	final String SELECTinstr = "SELECT * from producto p join instrumento i on p.idProducto = i.idProducto where nameP like"; 
	
	/**
	 * Method for the search of an instrument, if the user types a name, a brand or a model, 
	 * the application should show him any instrument that equals that.
	 * TODO Maybe let the user type something more than one word that equals any of these (name or model or brand),
	 * a complex search with more than one attribute
	 * @author Jago
	 */
	@Override
	public Set<Product> searchInstrument(String search) {
		ResultSet rs = null;
		Set<Product> listaProductos = new HashSet<Product>();
		
		try {
			connection.openConnection();
			
			stmt = con.prepareStatement(SELECTinstr);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if (rs.getString("name").equals(search) || rs.getString("brand").equals(search) || rs.getString("model").equals(search)) {			
					/**
					 * TODO Hacer método setDatos en otro sitio, preguntar donde
					 */
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

					/**
					 * Transformation of enum to String as JDBC doesn't support enums
					 */
					EnumClassInstrument enumClassInstr = EnumClassInstrument.valueOf(rs.getString("classInstrument"));
					prod.getInstrument().setClassInstrument(enumClassInstr);

					EnumTypeInstrument enumTypeInstr = EnumTypeInstrument.valueOf(rs.getString("typeInstrument"));
					prod.getInstrument().setTypeInstrument(enumTypeInstr);
				
					listaProductos.add(prod);	
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstrumentNotFoundException e) {
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
	
	@Override
	public Set<Product> searchComponent(String search) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> searchAccessory(String search) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
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

