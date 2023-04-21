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
	private int creditCard;
	private Set<Repair> repairSet;
	private Set<Purchase> purchaseRecord;
}
