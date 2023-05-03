package logicTier;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import model.EnumStatusManager;
import model.Manager;
import model.Member;
import model.User;

//TODO Change the import to the connector(check if neccesary)
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private Statement stmt; // Establish a Statement attribute
	private PreparedStatement ptmt; // Establish a PreparedStatement attribute
	private CallableStatement ctmt; // Establish a CallableStatement attribute
	private ResultSet rset; // Establish a ResultSet attribute
	private GateDB gate = new GateDB(); // Establish a GateDB attribute

	// --- SQL Sentences ---
	final String INSERTmember = "INSERT INTO user(idUser, username, password, name, surname, dateRegister, mail) VALUES( ?, ?, ?,?, ?, ?,?)";
	final String DELETEmember = "";

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
			//gate.closeConnection(ptmt, conn);
		}
	}

	@Override
	public void registerUserManager(Manager ma) throws UserFoundException, SQLException {
		try {
			// Open Connection with DB
			conn = gate.openConnection();

			// Check if the User is already registered
			if (!checkUserName(ma.getUserName())) {

				ptmt = conn.prepareStatement("{CALL insert_new_manager(?, ?, ?, ?, ?, ?, ?, ?,?,?)}");

				ptmt.setString(1, ma.getUserName());
				ptmt.setString(2, ma.getName());
				ptmt.setString(3, ma.getSurname());
				ptmt.setString(4, ma.getPassword());
				ptmt.setString(5, ma.getMail());
				ptmt.setDate(6, java.sql.Date.valueOf(ma.getDateRegister()));
				ptmt.setLong(7, ma.getIdSupervisor());
				ptmt.setBoolean(8, ma.isTechnician());
				ptmt.setBoolean(9, ma.isAdmin());
				ptmt.setObject(10,ma.getStatusManager());

				ptmt.executeUpdate();

			} else {
				// If User exists, throw UserFoundException.
				throw new UserFoundException();
			}
			;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			//gate.closeConnection(ptmt, conn);
		}
	}

	@Override
	public User userLogin(String userName, String password) throws WrongCredentialsException, UserNotFoundException {
		return null;
	}

	@Override
	public Manager verificationAdminToManager(Manager ma) throws UserNotFoundException {
		return null;
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
				new GateDB().closeConnection(ptmt, conn, rset);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

}
