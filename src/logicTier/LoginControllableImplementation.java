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
 *         This class allows to create Objects for the Log In cases.
 *
 */
public class LoginControllableImplementation implements LoginControllable {

	@Override
	public Member registerUserMember(String userName, String password)
			throws CredentialNotValidException, UserFoundException {
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
