package logicTier;

import java.sql.SQLException;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import model.Manager;
import model.Member;
import model.User;

/**
 * Interface with the methods used for the <i>Log In</i> and <i>Sign Up</i>
 * cases.
 * 
 * @author Ander Goirigolzarri Iturburu
 *
 */
public interface LoginControllable {

	/**
	 * Checks if a given username exists in the USER table of the database.
	 * 
	 * @param userName - the username to be checked
	 * @return existUserName - true if the username exists in the USER table, false
	 *         otherwise
	 * @throws SQLException if there is an error executing the SQL query
	 */
	public boolean checkUserName(String userName) throws SQLException;
	
	/**
	 * Registers a new member in the system with the provided Member object.
	 * 
	 * @param me the Member object containing the details of the member to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 */
	public void registerUserMember(Member me) throws CredentialNotValidException, UserFoundException, SQLException;

	/**
	 * Registers a new manager in the system with the provided Manager object.
	 * 
	 * @param me the Manager object containing the details of the manager to be
	 *           registered.
	 * @throws SQLException       if there is an error in the SQL statements or
	 *                            database connection.
	 * @throws UserFoundException if the username already exists in the database.
	 */
	public void registerUserManager(Manager ma) throws CredentialNotValidException, UserFoundException, SQLException;

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
	public User userLogin(String userName, String password)
			throws WrongCredentialsException, UserNotFoundException, SQLException;

	/**
	 * Updates the status of a manager in the database.
	 * 
	 * @param ma the Manager object containing the updated status.
	 * @throws UserNotFoundException if the manager is not found in the database.
	 * @throws SQLException          if there is an error in the SQL statements or
	 *                               database connection.
	 */
	public void verificationAdminToManager(Manager ma) throws UserNotFoundException, SQLException;

	/**
	 * Creates a Member object with the provided user ID.
	 * 
	 * @param idUser the ID of the member.
	 * @return the created Member object.
	 * @throws SQLException              if there is an error executing the SQL
	 *                                   query.
	 * @throws WrongCredentialsException if the member is not found in the database.
	 */
	public Member createMember(int idUser) throws SQLException, WrongCredentialsException;
	

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
	public Manager createManager(int idUser) throws SQLException, WrongCredentialsException;



}
