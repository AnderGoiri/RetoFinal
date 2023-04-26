package model;

import java.util.Set;
/**
	 * @author Ander
	 *         Represents a member of the system who can request repairs and make
	 *         purchases. Inherits from the base class {@link User}.
	 * 
	 *         <p>
	 *         A <code>Member</code> has a mailing address and a credit card number
	 *         associated with their account, as well as records of the repairs they
	 *         have requested and the purchases they have made.
	 *         </p>
	 */
public class Member extends User {

	private static final long serialVersionUID = 1L;

	// ---Attributes---
	private String address;
	private String creditCard;
	private Set<Repair> repairSet;
	private Set<Purchase> purchaseRecord;
	
	//--- Getters & Setters ---
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
	
	public Member(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// TODO: Change this
	}
	
}
