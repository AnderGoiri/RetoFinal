package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import model.Member;

class TestLoginControllableImplementation {

	private GateDB gate = new GateDB();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rset;
	private LoginControllableImplementation loginControl = new LoginControllableImplementation();

	final static String createMock = "INSERT INTO user(username,name,surname,password,mail,dateRegister) VALUES ('testuser','Test','User','test123','testuser@example.com','1990-01-01');";
	final static String deleteMock = "DELETE FROM user WHERE username='testuser';";

	@BeforeAll
	static void createMockUser() { //creates a mock user
		
		GateDB gate = new GateDB();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			conn = gate.openConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(createMock);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gate.closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterAll
	static void deleteMockUser() { // deletes the mock user from the DB
		
		GateDB gate = new GateDB();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = gate.openConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(deleteMock);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gate.closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

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
			conn = gate.openConnection();
			ptmt = conn.prepareStatement("SELECT 'testuser' FROM USER");
			rset = ptmt.executeQuery();
			assertTrue(loginControl.checkUserName("testuser"));
			assertFalse(loginControl.checkUserName("unknownuser"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gate.closeConnection(ptmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 	@Test
	void testRegisterUserMember() {

		String date = "1990-01-01";
		LocalDate localdate = LocalDate.parse(date);

		Member me = new Member("testuser", "Test", "User", "test123", "testuser@example.com", localdate, "123 Main St",
				"1234567890123456");

		loginControl = new LoginControllableImplementation();

		try {
			loginControl.registerUserMember(me); // Call the registerUserMember method
			String userName = me.getUserName();
			boolean findUser = loginControl.checkUserName(userName);
			assertTrue(findUser); // Check if the member was inserted into the
									// database
		} catch (CredentialNotValidException | UserFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				new GateDB().closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// Clean up the database after the test
		// TODO: deleteTestUserFromDB(me.getUserName());
	}
	 */

}
