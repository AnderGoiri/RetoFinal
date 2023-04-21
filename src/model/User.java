package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Ander
 *         <p>
 *         The <code>User</code> class is abstract as it is the base class for
 *         <code>Manager</code> and <code>Member</code> and it is not necessary
 *         to instantiate it in the program.<br/>
 *         The <code>User</code> class implements the Serializable interface as
 *         SQL can not work with objects. This interface helps to convert
 *         objects into byte streams.
 *         </p>
 */
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	// ---Attributes---
	protected int idUSer;
	protected String name; // IRL name of the user
	protected String surname;
	protected String userName; // name chosen by the user for the app
	protected String password;
	protected String mail;
	protected LocalDate dateRegister;

}
