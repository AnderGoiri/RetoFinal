package logicTier;

import java.sql.Connection;
import java.sql.SQLException;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import model.Manager;
import model.Member;
import model.User;

/**
 * 
 * Interface with the methods used for the <i>Log In</i> and <i>Sign Up</i>
 * cases.
 * 
 * @author Ander Goirigolzarri Iturburu
 *
 */
public interface LoginControllable {

	/**
	 * 
	 * Method to register a new member in the database.
	 * 
	 * @param me - Member object instantiation
	 * @throws CredentialNotValidException: Exception thrown when the credentials
	 *                                      given by the user are not valid.
	 * @throws UserFoundException:          Exception thrown when the User is found
	 *                                      in the database and it should not be.
	 * @throws SQLException:                Exception thrown when the SQL query
	 *                                      fails.
	 * @author Ander Goirigolzarri Iturburu
	 */
	public void registerUserMember(Member me) throws CredentialNotValidException, UserFoundException, SQLException;

	/**
	 * 
	 * Method to register a new Manager in the database.
	 * 
	 * @param ma - Manager object instantiation
	 * @throws CredentialNotValidException: Exception thrown when the credentials
	 *                                      given by the user are not valid.
	 * @throws UserFoundException:          Exception thrown when the User is found
	 *                                      in the database and it should not be.
	 * @throws SQLException:                Exception thrown when the SQL query
	 *                                      fails.
	 * @author Ander Goirigolzarri Iturburu
	 * 
	 */
	public void registerUserManager(Manager ma) throws CredentialNotValidException, UserFoundException, SQLException;

	/**
	 * 
	 * @param ma - Manager object instantiation
	 * @throws WrongCredentialsException: Exception thrown when the credentials
	 *                                    given by the user do not match the
	 *                                    credentials on the database
	 * @throws UserNotFoundException:     Exception thrown when the User is not
	 *                                    found on the database and it should be.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 * @return 
	 * @throws SQLException 
	 */
	public User userLogin(String userName, String password) throws WrongCredentialsException, UserNotFoundException, SQLException;

	/**
	 * 
	 * @param ma - Manager object created
	 * @return
	 * @throws UserNotFoundException: Exception thrown when the User is not found on
	 *                                the database and it should be.
	 * @throws SQLException 
	 * @author Ander Goirigolzarri Iturburu
	 */
	public void verificationAdminToManager(Manager ma) throws UserNotFoundException, SQLException;
	
	public Member createMember(int idUser, Connection conn) throws SQLException, WrongCredentialsException;
	
	public Manager createManager(int idUser, Connection conn) throws SQLException, WrongCredentialsException;

}
