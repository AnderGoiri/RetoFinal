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

/**
 * 
 * @author Ander
 * 
 *         This class allows to create Objects for the Log In cases.
 *
 */
public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private Statement stmt; // Establish a Statement attribute
	private PreparedStatement ptmt; // Establish a PreparedStatement attribute
	private ResultSet rset; // Establish a ResultSet attribute

	/**
	 * Method used to check if a User Name is already used in the database.
	 * 
	 * @author Ander
	 * @param userName
	 * @return When false is returned, the User Name does not appear on the
	 *         database. When true is returned, the User Name has been found on the
	 *         database.
	 * @throws SQLException
	 */
	public boolean checkUserName(String userName) throws SQLException { // !!!!Query is not placed

		String queryCheck = " ";

		try {
			conn = new GateDB().openConnection(); // openConnection method opens the connection with our DB
			rset = conn.prepareStatement(queryCheck).executeQuery(); // execute the Query
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			new GateDB().closeConnection(ptmt, conn, rset);
		}
		return rset.next(); // return a boolean
	}

	@Override
	public void registerUserMember(Member me) throws CredentialNotValidException, UserFoundException, SQLException {

		try {
			conn = new GateDB().openConnection();// Open Connection with DB
			
			if (!checkUserName(me.getUserName())) { // Check if the User is already registered
				
				stmt = conn.prepareStatement(" ");
				stmt.executeUpdate(null);
				
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
