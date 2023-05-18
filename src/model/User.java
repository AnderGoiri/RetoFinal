package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * The <code>User</code> class is abstract as it is the base class for
 * <code>Manager</code> and <code>Member</code> and it is not necessary to
 * instantiate it in the program.<br/>
 * The <code>User</code> class implements the Serializable interface as SQL can
 * not work with objects. This interface helps to convert objects into byte
 * streams.
 * </p>
 * 
 * @author Ander Goirigolzarri Iturburu
 * 
 */
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	// ---Attributes---
	protected int idUser;
	protected String name; // IRL name of the user
	protected String surname;
	protected String userName; // name chosen by the user for the app
	protected String password;
	protected String mail;
	protected LocalDate dateRegister;

	// --- Getters & Setters ---
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}

	public User() {
	}

	public User(int idUser, String userName, String name, String surname, String password, String mail,
			LocalDate dateRegister) {
		this.idUser = idUser;
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.mail = mail;
		this.dateRegister = dateRegister;
	}

	public User(String userName, String name, String surname, String password, String mail, LocalDate dateRegister) {
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.mail = mail;
		this.dateRegister = dateRegister;
	}
}
