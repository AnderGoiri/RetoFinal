package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import model.Manager;
import model.Member;

class TestLoginControllableImplementation {

	private GateDB gate = new GateDB();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ptmt;
	private ResultSet rset;
	private LoginControllableImplementation loginControl = new LoginControllableImplementation();

	private Member me = new Member("testuser", "Test", "User", "test123", "testuser@example.com",
			LocalDate.parse("1990-01-01"), "123 Main St", "1234567890123456");

	private Manager ma = new Manager("testuser", "Test", "User", "test123", "testuser@example.com",
			LocalDate.parse("1990-01-01"), 0, false, false);

	final static String createMock = "INSERT INTO user(username,name,surname,password,mail,dateRegister) VALUES ('mockuser','Mock','User','mock123','mockuser@example.com','1990-01-01');";
	final static String deleteMock = "DELETE FROM user WHERE username='mockuser';";

	/**
	 * This test class contains a method that creates a mock user by executing a SQL
	 * query on a test database. The method annotated with {@code @BeforeAll} is
	 * executed before any tests in the class are run. The mock user is created
	 * using the {@code GateDB} class to open a connection to the database and
	 * execute the query. If the query fails, a {@code SQLException} is thrown and
	 * the stack trace is printed. The method then closes the connection to the
	 * database using the {@code closeConnection} method from the {@code GateDB}
	 * class.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	
	@BeforeAll
	static void createMockUser() { // creates a mock user

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

	/**
	 * Deletes the mock user from the database after all tests have run.
	 * <p>
	 * This method is annotated with the {@code @AfterAll} annotation, indicating
	 * that it should be executed after all test methods in the test class have run.
	 * It first creates a new instance of the {@code GateDB} class to establish a
	 * connection to the database. It then executes an SQL statement to delete the
	 * mock user created in the {@code createMockUser()} method. Finally, it closes
	 * the connection to the database.
	 * </p>
	 */
	@Ignore
	//@AfterAll
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
	 * It asserts that the method returns true if the given <code>username</code>
	 * exists in the USER table, and false if it does not.
	 * 
	 * @throws SQLException if there is an error executing the SQL query
	 * @author Ander Goirigolzarri Iturburu
	 */

	@Ignore 
	//@Test
	void testCheckUserNameWhenUserNameIsInDB() throws SQLException {
		// call method CheckUserName
		assertTrue(loginControl.checkUserName("mockuser"));
	}

	//@Ignore
	@Test
	void testCheckUserNameWhenUserNameIsNotInDB() throws SQLException {
		// c1all method CheckUserName
		assertFalse(loginControl.checkUserName(me.getUserName().concat("fail")));
	}

	/**
	 * Unit test for the {@link LoginControl#registerUserMember(Member)} method.
	 * <p>
	 * The test verifies that the {@code Member} object provided as a parameter is
	 * properly inserted into the database using the
	 * {@link GateDB#closeConnection(Statement, Connection, ResultSet)} method to
	 * close the database connection.
	 * </p>
	 * <p>
	 * If the registration is successful, the test then checks if the newly created
	 * user exists in the database using the
	 * {@link LoginControl#checkUserName(String)} method.
	 * </p>
	 * <p>
	 * If the test fails to register the user, throw an exception.
	 * </p>
	 */
	@Ignore // @Expected
	// @Test
	void testRegisterUserMember() {
		try {
			loginControl.registerUserMember(me); // Call the registerUserMember method
			assertTrue(loginControl.checkUserName(me.getUserName())); // Check if the member was inserted into the
			// database
		} catch (CredentialNotValidException | UserFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gate.closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Ignore
	//@Test
	void testRegisterNewUserMemberSuccesful() throws CredentialNotValidException, UserFoundException, SQLException {
		loginControl.registerUserMember(me); // Call the registerUserMember method
	}

	/**
	 * Unit test for the {@link LoginControl#registerUserMember(Manager)} method.
	 * <p>
	 * The test verifies that the {@code Manager} object provided as a parameter is
	 * properly inserted into the database using the
	 * {@link GateDB#closeConnection(Statement, Connection, ResultSet)} method to
	 * close the database connection.
	 * </p>
	 * <p>
	 * If the registration is successful, the test then checks if the newly created
	 * user exists in the database using the
	 * {@link LoginControl#checkUserName(String)} method.
	 * </p>
	 * <p>
	 * If the test fails to register the user, throw an exception.
	 * </p>
	 */
	@Ignore
	// @Test
	void testRegisterUserManager() {
		try {
			loginControl.registerUserManager(ma); // Call the registerUserMember method
			assertTrue(loginControl.checkUserName(ma.getUserName())); // Check if the manager was inserted into the
			// database
		} catch (CredentialNotValidException | UserFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gate.closeConnection(stmt, conn, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
