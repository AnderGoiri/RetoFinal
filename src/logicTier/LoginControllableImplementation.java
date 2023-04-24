package logicTier;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;

import model.Manager;
import model.Member;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Ander
 * 
 *         This class allows to create Objects for the Log In cases.
 *
 */
public class LoginControllableImplementation implements LoginControllable {

	private Connection conn; // Establish a Connection attribute
	private PreparedStatement stmt; // Establish a PreparedStatement attribute

	/**
	 * Method used to open a connection with the database
	 * 
	 * @throws SQLException
	 */
	private void openConnection() throws SQLException { // método para conexiones solo con la URL
		conn = DriverManager.getConnection("jdbc:mysql://hostname/database"); // placeholder
	}

	private void openConnection(String userName, String password) throws SQLException { // método con conexiones con
																						// URL, username y pass
		conn = DriverManager.getConnection("jdbc:mysql://hostname/database", userName, password); // placeholder
	}

	/**
	 * 
	 * Method used to close a connection with the database
	 * 
	 * @throws SQLException
	 */
	private void closeConnection() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public Member registerUserMember(String userName, String password)
			throws CredentialNotValidException, UserFoundException, SQLException {
		// conectarse a la base de datos
			openConnection(userName, password);

			
			
			closeConnection();
		// comprobar que el usuario y contraseña no esten registrados

		// si lo están, mandar mensaje de error, terminar el metodo

		return null;
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
