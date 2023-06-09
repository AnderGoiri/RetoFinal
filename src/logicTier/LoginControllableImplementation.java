package logicTier;

import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import model.EnumStatusManager;
import model.Manager;
import model.Member;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * The LoginControllableImplementation class implements the LoginControllable
 * interface and provides methods for user registration and authentication.
 * 
 * It interacts with a database to perform the necessary operations.
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private PreparedStatement ptmt; // Establish a PreparedStatement attribute
	private GateDB gate = new GateDB(); // Establish a GateDB attribute

	
	/**
	 * Checks if a given username exists in the USER table of the database.
	 * 
	 * @param userName - the username to be checked
	 * @return existUserName - true if the username exists in the USER table, false
	 *         otherwise
	 * @throws SQLException if there is an error executing the SQL query
	 */
	@Override
	public boolean checkUserName(String userName) throws SQLException {
		return conn.createStatement().executeQuery("SELECT username FROM USER WHERE username LIKE '" + userName + "';").next();
	}

	/**
	 * Registers a new member in the system with the provided Member object.
	 * 
	 * @param me the Member object containing the details of the member to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 */
	@Override
	public void registerUserMember(Member me) throws SQLException, UserFoundException {
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
			throw new UserFoundException(
					"The user already exists. Please choose a different username or try logging in.");
			// Throw this exception if a User is found
		}
		gate.closeConnection(ptmt, conn);
	}

	/**
	 * Registers a new manager in the system with the provided Manager object.
	 * 
	 * @param me the Manager object containing the details of the manager to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 */
	@Override
	public void registerUserManager(Manager ma) throws UserFoundException, SQLException {
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
			ptmt.setString(11, ma.getStatusManager().getLabel());

			ptmt.executeUpdate();

		} else {
			// If User exists, throw UserFoundException.
			throw new UserFoundException(
					"The user already exists. Please choose a different username or try logging in.");
		}
		gate.closeConnection(ptmt, conn);
	}

	/**
	 * Authenticates a user with the provided username and password.
	 * 
	 * @param username the username of the user attempting to log in.
	 * @param password the password of the user attempting to log in.
	 * @throws WrongCredentialsException if the provided credentials are incorrect.
	 * @throws UserNotFoundException     if the specified user does not exist in the
	 *                                   system.
	 * @throws SQLException
	 */
	@Override
	public User userLogin(String username, String password)
			throws WrongCredentialsException, UserNotFoundException, SQLException {
		ResultSet rset = null;
		// Open connection with DB
		conn = gate.openConnection();

		// Prepare the statement
		ptmt = conn.prepareStatement("SELECT u.username, u.password, m.idUser, ma.idUser FROM user u "
				+ "LEFT JOIN member m ON u.idUser = m.idUser " + "LEFT JOIN manager ma ON u.idUser = ma.idUser "
				+ "WHERE u.username = ? AND u.password = ?");

		ptmt.setString(1, username);
		ptmt.setString(2, password);

		rset = ptmt.executeQuery();

		if (!rset.next()) {
			throw new WrongCredentialsException(
					"The provided credentials are incorrect. Please make sure you have entered the correct username and password.");
		}

		// Check if the result set contains a manager or member ID
		int memberId = rset.getInt("m.idUser");
		int managerId = rset.getInt("ma.idUser");

		if (memberId != 0) {
			// This is a member
			Member auxMember = createMember(memberId); // Creates an auxiliar object Member
			gate.closeConnection(ptmt, conn);
			return auxMember;
		} else if (managerId != 0) {
			// This is a manager
			Manager auxManager = createManager(managerId);// Creates an auxiliar object Manager
			gate.closeConnection(ptmt, conn);
			return auxManager;
		} else {
			throw new UserNotFoundException(
					"The specified user does not exist in the system. Please verify the username and try again or register as a new user.");
		}
	}

	/**
	 * Updates the status of a manager in the database.
	 * 
	 * @param ma the Manager object containing the updated status.
	 * @throws UserNotFoundException if the manager is not found in the database.
	 * @throws SQLException          if there is an error in the SQL statements or
	 *                               database connection.
	 */
	@Override
	public void verificationAdminToManager(Manager ma) throws UserNotFoundException, SQLException {
		// Open the connection with the database
		conn = gate.openConnection();

		final String UPDATEstatusManager = "UPDATE manager SET statusManager=? WHERE id = ?";

		ptmt = conn.prepareStatement(UPDATEstatusManager);

		ptmt.setString(1, ma.getStatusManager().getLabel());
		ptmt.setInt(2, ma.getIdUser());

		ptmt.executeUpdate();
		gate.closeConnection(ptmt, conn);
	}

	/**
	 * Creates a Member object with the provided user ID.
	 * 
	 * @param idUser the ID of the member.
	 * @return the created Member object.
	 * @throws SQLException              if there is an error executing the SQL
	 *                                   query.
	 * @throws WrongCredentialsException if the member is not found in the database.
	 */
	@Override
	public Member createMember(int idUser) throws SQLException, WrongCredentialsException {
		ResultSet rset = null;
		ptmt = conn.prepareStatement("SELECT * FROM vw_member WHERE idUser =" + idUser + ";");

		rset = ptmt.executeQuery();

		if (!rset.next()) {
			throw new WrongCredentialsException("You have entered an invalid username or password");
		}

		String username = rset.getString(2);
		String name = rset.getString(3);
		String surname = rset.getString(4);
		String password = rset.getString(5);
		String mail = rset.getString(6);
		LocalDate dateRegister = rset.getDate(7).toLocalDate();
		String address = rset.getString(8);
		String creditCard = rset.getString(9);
   

		return new Member(username, name, surname, password, mail, dateRegister, address, creditCard);
	}

	/**
	 * Creates a Manager object with the provided user ID and database connection.
	 * 
	 * @param idUser the ID of the manager.
	 * @param conn   the database connection.
	 * @return the created Manager object.
	 * @throws SQLException              if there is an error executing the SQL
	 *                                   query.
	 * @throws WrongCredentialsException if the manager is not found in the
	 *                                   database.
	 */
	@Override
	public Manager createManager(int idUser) throws SQLException, WrongCredentialsException {
		ResultSet rset = null;
		ptmt = conn.prepareStatement("SELECT * FROM vw_manager WHERE idUser =" + idUser + ";");
		
		rset = ptmt.executeQuery();

		if (!rset.next()) {
			throw new WrongCredentialsException("You have entered an invalid username or password");
		}

		String username = rset.getString(2);
		String name = rset.getString(3);
		String surname = rset.getString(4);
		String password = rset.getString(5);
		String mail = rset.getString(6);
		LocalDate dateRegister = rset.getDate(7).toLocalDate();
		int idSupervisor = rset.getInt(8);
		boolean isSupervisor = rset.getBoolean(9);
		boolean isTechnician = rset.getBoolean(10);
		boolean isAdmin = rset.getBoolean(11);
		EnumStatusManager statusManager = EnumStatusManager.getValue(rset.getString(12));
		
		
    return new Manager(username, name, surname, password, mail, dateRegister, idSupervisor, isSupervisor,
				isTechnician, isAdmin, statusManager);
	}


}
