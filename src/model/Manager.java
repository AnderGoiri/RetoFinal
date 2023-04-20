package model;

import java.util.Set;

public class Manager extends User {

	private static final long serialVersionUID = 1L;
	// ---Attributes---
	private int idSupervisor;
	private boolean isTechnician;
	private boolean isAdmin;
	private EnumStatusManager statusManager;
	private Set<Repair> repairSet;
	private Set<Management> managementSet;

	
	
	

}
