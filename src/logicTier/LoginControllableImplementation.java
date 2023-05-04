package logicTier;

import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;

import model.Manager;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private Statement stmt; // Establish a Statement attribute
	private PreparedStatement ptmt; // Establish a PreparedStatement attribute
	private ResultSet rset; // Establish a ResultSet attribute
	private GateDB gate = new GateDB(); // Establish a GateDB attribute

	/**
	 * Checks if a given username exists in the USER table of the database.
	 * 
	 * @param userName - the username to be checked
	 * @return existUserName - true if the username exists in the USER table, false
	 *         otherwise
	 * @throws SQLException if there is an error executing the SQL query
	 * @author Ander Goirigolzarri Iturburu
	 */
	public boolean checkUserName(String userName) throws SQLException {
		return gate.openConnection().createStatement()
				.executeQuery("SELECT username FROM USER WHERE username LIKE '" + userName + "';").next();
	}

	/**
	 * Registers a new member in the system with the provided Member object.
	 * 
	 * @param me the Member object containing the details of the member to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Override
	public void registerUserMember(Member me) throws SQLException, UserFoundException {
		try {
			// Open Connection with DB
			conn = gate.openConnection();

			// Check if the User is already registered
			if (!checkUserName(me.getUserName())) {

				ptmt = conn.prepareStatement("CALL insert_new_member(?, ?, ?, ?, ?, ?, ?, ?)");

				ptmt.setString(1, me.getUserName());
				ptmt.setString(2, me.getName());
				ptmt.setString(3, me.getSurname());
				ptmt.setString(4, me.getPassword());
				ptmt.setString(5, me.getMail());
				ptmt.setDate(6, java.sql.Date.valueOf(me.getDateRegister()));
				ptmt.setString(7, me.getAddress());
				ptmt.setString(8, me.getCreditCard());

				ptmt.executeUpdate();

			} else {
				throw new UserFoundException("User found");
			}
			;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			// gate.closeConnection(ptmt, conn);
		}
	}

	/**
	 * Registers a new manager in the system with the provided Manager object.
	 * 
	 * @param me the Manager object containing the details of the manager to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Override
	public void registerUserManager(Manager ma) throws UserFoundException, SQLException {
		try {
			// Open Connection with DB
			conn = gate.openConnection();

			// Check if the User is already registered
			if (!checkUserName(ma.getUserName())) {

				ptmt = conn.prepareStatement("{CALL insert_new_manager(?, ?, ?, ?, ?, ?, ?, ?,?,?,?)}");

				ptmt.setString(1, ma.getUserName());
				ptmt.setString(2, ma.getName());
				ptmt.setString(3, ma.getSurname());
				ptmt.setString(4, ma.getPassword());
				ptmt.setString(5, ma.getMail());
				ptmt.setDate(6, java.sql.Date.valueOf(ma.getDateRegister()));
				ptmt.setLong(7, ma.getIdSupervisor());
				ptmt.setBoolean(8, ma.isSupervisor());
				ptmt.setBoolean(9, ma.isTechnician());
				ptmt.setBoolean(10, ma.isAdmin());
				ptmt.setObject(11, ma.getStatusManager());

				ptmt.executeUpdate();

			} else {
				// If User exists, throw UserFoundException.
				throw new UserFoundException("User found");
			}
			;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			// gate.closeConnection(ptmt, conn);
		}
	}

	/**
	 * Authenticates a user with the provided username and password.
	 * 
	 * @param username the username of the user attempting to log in.
	 * @param password the password of the user attempting to log in.
	 * @throws WrongCredentialsException if the provided credentials are incorrect.
	 * @throws UserNotFoundException     if the specified user does not exist in the
	 *                                   system.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Override
	public void userLogin(String username, String password) throws WrongCredentialsException, UserNotFoundException {
		try {
			// Open connection with DB
			conn = gate.openConnection();

			// Prepare the statement
			ptmt = conn.prepareStatement("SELECT username, password FROM user where username=? and password=?");

			ptmt.setString(1, username);
			ptmt.setString(2, password);

			rset = ptmt.executeQuery();

			if (!rset.next()) {
				throw new WrongCredentialsException("You have entered an invalid username or password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Manager verificationAdminToManager(Manager ma) throws UserNotFoundException {
		boolean changes = false;
		
		conn = gate.openConnection();
		
		//stmt = conn.prepareStatement("UPDATE manager SET ");
		
		
		return ma;
	}

	@Override
	public void deleteUserMember(Member me) throws UserNotFoundException {
		try {
			ptmt = conn.prepareStatement(null);

			ptmt.setLong(1, me.getIdUser());

			stmt.executeUpdate(null);

		} catch (SQLException e1) {
			System.out.println("Error en la modificaci�n SQL");
			e1.printStackTrace();
		} finally {
			try {
				gate.closeConnection(ptmt, conn, rset);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

}
