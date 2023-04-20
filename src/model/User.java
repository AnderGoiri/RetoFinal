package model;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class User implements Serializable {

	/**
	 * The <p>"User"</p> class is abstract as it is the base class for <p>"Manager"</p> and
	 * <p>"Member"</p> and it is not necessary to instantiate it in the program.<br/>
	 * The <p>"User"</p> class implements the Serializable interface as SQL can not work
	 * with objects. This interface helps to convert objects into byte streams.
	 */
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
