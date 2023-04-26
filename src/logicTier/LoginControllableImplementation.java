package logicTier;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;

import model.Manager;
import model.Member;
import model.User;

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

	// --- SQL Sentences ---
	final String INSERTmember = "INSERT INTO user(idUser, username, password, name, surname, dateRegister, mail) VALUES( ?, ?, ?,?, ?, ?,?)";

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
			rset = conn.createStatement().executeQuery(queryCheck); // execute the Query
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
		try {
			conn = new GateDB().openConnection();// Open Connection with DB

			if (!checkUserName(me.getUserName())) { // Check if the User is already registered

				ptmt = conn.prepareStatement(INSERTmember);
				
				ptmt.setLong(0, me.getIdUser());
				ptmt.setString(1, me.getUserName());
				ptmt.setString(2, me.getPassword());
				ptmt.setString(3, me.getName());
				ptmt.setString(4, me.getSurname());
				//ptmt.setDate(5, me.getDateRegister(), null);
				//TODO Parse the LocalDate variable from User.java
				ptmt.setString(6, me.getMail());

				ptmt.executeUpdate();

			} else { // If User exists, throw UserFoundException.
				throw new UserFoundException();
			}
			;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			new GateDB().closeConnection(ptmt, conn, rset);
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

}
