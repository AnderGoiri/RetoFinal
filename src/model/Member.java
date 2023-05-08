package model;

import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a member of the system who can request repairs and make purchases.
 * Inherits from the base class {@link User}.
 * 
 * <p>
 * A <code>Member</code> has a mailing address and a credit card number
 * associated with their account, as well as records of the repairs they have
 * requested and the purchases they have made.
 * </p>
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class Member extends User {

	private static final long serialVersionUID = 1L;

	// ---Attributes---
	private String address;
	private String creditCard;
	private Set<Repair> repairSet;
	private Set<Purchase> purchaseRecord;

	// --- Getters & Setters ---
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Set<Repair> getRepairSet() {
		return repairSet;
	}

	public void setRepairSet(Set<Repair> repairSet) {
		this.repairSet = repairSet;
	}

	public Set<Purchase> getPurchaseRecord() {
		return purchaseRecord;
	}

	public void setPurchaseRecord(Set<Purchase> purchaseRecord) {
		this.purchaseRecord = purchaseRecord;
	}

	// ---Constructors---
	public Member(String address, String creditCard, Set<Repair> repairSet, Set<Purchase> purchaseRecord) {
		super();
		this.address = address;
		this.creditCard = creditCard;
		this.repairSet = repairSet;
		this.purchaseRecord = purchaseRecord;
	}

	public Member() {
		super();
	}

	public Member(int idUser, String userName, String name, String surname, String password, String mail,
			LocalDate dateRegister, String address, String creditCard) {
		super(idUser, userName, name, surname, password, mail, dateRegister);
		this.address = address;
		this.creditCard = creditCard;
	}

	public Member(String userName, String name, String surname, String password, String mail, LocalDate dateRegister,
			String address, String creditCard) {
		super(userName, name, surname, password, mail, dateRegister);
		this.address = address;
		this.creditCard = creditCard;
	}
}
