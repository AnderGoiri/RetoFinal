package model;

import java.time.LocalDate;

/**
 * Class that registers a user action on a product
 * 
 * @author Jago Bartolomé Barroso
 */
public class Management {
	// ---Attributes---
	private int idManagement;
	private EnumAction actionType;
	private String descriptionM;
	private LocalDate date;
	private String idUser;
	private String idProduct;
	
	// --- Getters & Setters ---
	public int getIdManagement() {
		return idManagement;
	}
	public void setIdManagement(int idManagement) {
		this.idManagement = idManagement;
	}
	public EnumAction getActionType() {
		return actionType;
	}
	public void setActionType(EnumAction actionType) {
		this.actionType = actionType;
	}
	public String getDescriptionM() {
		return descriptionM;
	}
	public void setDescriptionM(String descriptionM) {
		this.descriptionM = descriptionM;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	
	// --- Constructors ---
	public Management(int idManagement, EnumAction actionType, String descriptionM, LocalDate date, String idUser,
			String idProduct) {
		super();
		this.idManagement = idManagement;
		this.actionType = actionType;
		this.descriptionM = descriptionM;
		this.date = date;
		this.idUser = idUser;
		this.idProduct = idProduct;
	}
	public Management() {
		super();
	}
}
