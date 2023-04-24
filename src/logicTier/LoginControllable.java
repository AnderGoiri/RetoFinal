package logicTier;

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

	public Member registerUserMember(String userName, String password)
			throws CredentialNotValidException, UserFoundException;

	public Manager registerUserManager(String userName, String password)
			throws CredentialNotValidException, UserFoundException;

	public User userLogin(String userName, String password) throws WrongCredentialsException, UserNotFoundException;

	public Manager verificationAdminToManager(Manager ma) throws UserNotFoundException;

}
