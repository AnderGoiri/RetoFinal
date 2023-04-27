package logicTier;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;

import model.Manager;
import model.Member;
import model.User;

//TODO Change the import to the connector
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private Statement stmt; // Establish a Statement attribute
	private PreparedStatement ptmt; // Establish a PreparedStatement attribute
	private CallableStatement ctmt; // Establish a CallableStatement attribute
	private ResultSet rset; // Establish a ResultSet attribute

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

		String queryCheck = "SELECT username FROM USER WHERE username LIKE '" + userName + "';";
		boolean existUserName = false; // We need a variable to store the result as rset will be closed with the
										// connection
		try {
			conn = new GateDB().openConnection(); // openConnection method opens the connection with our DB
			rset = conn.prepareStatement(queryCheck).executeQuery(); // execute the Query
			existUserName = rset.next(); // return a boolean
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			new GateDB().closeConnection(ptmt, conn, rset);
		}
		return existUserName;
	}

	@Override
	public void registerUserMember(Member me) throws CredentialNotValidException, UserFoundException, SQLException {
		GateDB gateDB = new GateDB();
		try {
			
			conn = gateDB.openConnection();// Open Connection with DB

			if (!checkUserName(me.getUserName())) { // Check if the User is already registered

				ctmt = conn.prepareCall("{CALL insert_new_member(?, ?, ?, ?, ?, ?, ?, ?)}");

				ctmt.setString(1, me.getUserName());
				ctmt.setString(2, me.getName());
				ctmt.setString(3, me.getSurname());
				ctmt.setString(4, me.getPassword());
				ctmt.setString(5, me.getMail());
				ctmt.setDate(6, java.sql.Date.valueOf(me.getDateRegister()));
				ctmt.setString(7, me.getAddress());
				ctmt.setString(8, me.getCreditCard());

				ctmt.executeUpdate();

			} else { 
				throw new UserFoundException(); // If User exists, throw UserFoundException.
			}
			;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			gateDB.closeConnection(ctmt, conn, rset);
		}
	}

	@Override
	public Manager registerUserManager(String userName, String password)
			throws CredentialNotValidException, UserFoundException {
		return null;
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
