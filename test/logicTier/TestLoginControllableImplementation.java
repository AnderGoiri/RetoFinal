package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

class TestLoginControllableImplementation {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rset;
	private LoginControllableImplementation loginControl;

	/**
	 * 
	 * Tests the {@link LoginControllableImplementation#checkUserName()
	 * checkUserName} method of the {@link LoginControllableImplementation} class.
	 * It asserts that the method returns true if the given username exists in the
	 * USER table, and false if it does not.
	 * 
	 * @throws SQLException if there is an error executing the SQL query
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testCheckUserName() {
		try {
			loginControl = new LoginControllableImplementation();
			conn = new GateDB().openConnection();
			stmt = conn.prepareStatement("SELECT * FROM USER");
			rset = stmt.executeQuery();
			assertTrue(loginControl.checkUserName("Admin"));
			assertFalse(loginControl.checkUserName("unknownuser"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				new GateDB().closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	void testRegisterUserMember() {
		
	}

}