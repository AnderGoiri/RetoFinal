package logicTier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import exceptions.ProductNotFoundException;
import model.Instrument;
import model.Product;

public class Main {

	public static void main(String[] args) {
		Connection conn; // Establish a Connection attribute
		PreparedStatement ptmt; // Establish a PreparedStatement attribute
		GateDB gate = new GateDB(); // Establish a GateDB attribute

		//We create new product
		ProductMemberControllable p = new ProductMemberControllableImplementation();
		
		
		try {
			conn = gate.openConnection();
			ptmt = conn.prepareStatement("CALL insert_new_instrument(?, ?, ?, ?, ? , ? , ?, ?, ?, ?, ?, ?)");
			

	        ptmt.setString(1, "Yamaha");
	        ptmt.setString(2, "DX7");
	        ptmt.setString(3, "A classic FM synthesizer");
	        ptmt.setInt(4, 2500);
	        ptmt.setInt(5, 10);
	        ptmt.setInt(6, 1);
	        ptmt.setInt(7, 0);
	        ptmt.setInt(8, 0);
	        ptmt.setString(9, "DX7");
	        ptmt.setString(10, "Black");
	        ptmt.setString(11, "String");
	        ptmt.setString(12, "Electronic");
			ptmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			int search = 1;
			boolean existe = false;
			existe = p.existsProduct(search);
			System.out.println(existe);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
