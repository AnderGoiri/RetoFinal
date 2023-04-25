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
 * 
 * @author Ander
 * 
 *         Interface with the methods used for the <i>Log In</i> and <i>Sign
 *         Up</i> cases.
 *
 */
public interface LoginControllable {

	/**
	 * 
	 * Method to register a new member in the database.
	 * 
	 * @param userName: Name chosen by the User to identify themselves in the app
	 * @param password: Password of the User
	 * @return
	 * @throws CredentialNotValidException: Exception thrown when the credentials
	 *                                      given by the user are not valid.
	 * @throws UserFoundException:          Exception thrown when the User is found
	 *                                      in the database and it should not be.
	 * @throws SQLException 
	 */
	public void registerUserMember(Member me)
			throws CredentialNotValidException, UserFoundException, SQLException;

	/**
	 * 
	 * Method to register a new Manager in the database.
	 * 
	 * @param userName: Name chosen by the User to identify themselves in the app
	 * @param password: Password of the User
	 * @return
	 * @throws CredentialNotValidException: Exception thrown when the credentials
	 *                                      given by the user are not valid.
	 * @throws UserFoundException:          Exception thrown when the User is found
	 *                                      in the database and it should not be.
	 */
	public Manager registerUserManager(String userName, String password)
			throws CredentialNotValidException, UserFoundException;

	/**
	 * 
	 * @param userName: Name chosen by the User to identify themselves in the app
	 * @param password: Password of the User
	 * @return
	 * @throws WrongCredentialsException: Exception thrown when the credentials
	 *                                    given by the user do not match the
	 *                                    credentials on the database
	 * @throws UserNotFoundException:     Exception thrown when the User is not
	 *                                    found on the database and it should be.
	 */
	public User userLogin(String userName, String password) throws WrongCredentialsException, UserNotFoundException;

	/**
	 * 
	 * @param ma: Manager object created
	 * @return
	 * @throws UserNotFoundException: Exception thrown when the User is not found on
	 *                                the database and it should be.
	 */
	public Manager verificationAdminToManager(Manager ma) throws UserNotFoundException;

}
