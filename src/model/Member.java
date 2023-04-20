package model;

import java.util.Set;

public class Member extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ---Attributes---
	private String address;
	private int creditCard;
	private Set<Repair> repairSet;
	private Set<Purchase> purchaseRecord;
}
