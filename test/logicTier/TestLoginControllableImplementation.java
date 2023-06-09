package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

//import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.UserFoundException;
import model.EnumStatusManager;
import model.Manager;
import model.Member;

class TestLoginControllableImplementation {

	private GateDB gate = new GateDB();
	private LoginControllableImplementation loginControl = new LoginControllableImplementation();

	private Member me = new Member("testusermember", "Test", "User", "test123", "testuser@example.com",
			LocalDate.parse("1990-01-01"), "123 Main St", "1234567890123456");

	private Manager ma = new Manager("testusermanager", "Test", "User", "test123", "testuser@example.com",
			LocalDate.parse("1990-01-01"), 1, false, false, false, EnumStatusManager.P);

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
			gate.closeConnection();
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
			gate.closeConnection();
		}
	}

	/**
	 * Sets up the connection with the database before each test method is executed.
	 * This method is annotated with the "@BeforeEach" annotation to indicate that
	 * it should be executed before each test method. It uses the "openConnection"
	 * method of the "gate" object to establish a connection with the database.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	@BeforeEach
	void openConnectionWithDBForTesting() {
		gate.openConnection();
	}

	/**
	 * This method is executed after each test method in the class. It closes the
	 * connection with the database after the execution of the test method. It is
	 * important to close the connection with the database to avoid resource leaks
	 * and ensure that the next test case starts with a fresh database connection.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	@AfterEach
	void closeConnectionWithDBAfterTesting() {
		gate.closeConnection();
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
	// @Ignore
	@Test
	void testCheckUserNameWhenUserNameIsInDB() throws SQLException {
		assertTrue(loginControl.checkUserName("mockuser"));
	}

	/**
	 * This JUnit test method checks the functionality of the checkUserName method
	 * of the loginControl class when the provided username is not present in the
	 * database. The method attempts to concatenate the username with the string
	 * "fail" and checks if the result is false.
	 * 
	 * @throws SQLException if there is an error accessing the database.
	 * @author Ander Goirigolzarri Iturburu
	 */
	// @Ignore
	@Test
	void testCheckUserNameWhenUserNameIsNotInDB() throws SQLException {
		assertFalse(loginControl.checkUserName(me.getUserName().concat("fail")));
	}

	/**
	 * 
	 * Tests the successful registration of a new user member using the
	 * registerUserMember method of the LoginControl class.
	 * 
	 * @throws SQLException       if there is an error with the database connection
	 *                            or query execution.
	 * @throws UserFoundException if the user is already registered in the database.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testRegisterNewUserMemberSuccesful() throws SQLException, UserFoundException {
		// Call the registerUserMember method
		loginControl.registerUserMember(me);
		UserFoundException ufe = Assertions.assertThrows(UserFoundException.class, () -> {
			loginControl.registerUserMember(me);
		});
		Assertions.assertEquals("User found", ufe.getMessage());
	}

	/**
	 * 
	 * Tests the successful registration of a new user manager using the
	 * registerUserManager method of the LoginControl class.
	 * 
	 * @throws SQLException       if there is an error with the database connection
	 *                            or query execution.
	 * @throws UserFoundException if the user is already registered in the database.
	 * @author Ander Goirigolzarri Iturburu
	 */
	// @Ignore
	@Test
	void testRegisterNewUserManagerSuccesful() throws UserFoundException, SQLException {
		// Call the registerUserMember method
		loginControl.registerUserManager(ma);
		UserFoundException ufe = Assertions.assertThrows(UserFoundException.class, () -> {
			loginControl.registerUserManager(ma);
		});
		Assertions.assertEquals("User found", ufe.getMessage());
	}

	@Test
	void testUserLoginSuccesful() {

	}
}
