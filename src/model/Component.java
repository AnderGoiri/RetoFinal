package model;

import java.util.Set;

/**
 * @author Jago
 * Derived class Component from Product
 */
public class Component extends Product{
	// ---Attributes---
	private static final long serialVersionUID = 1L;
	private EnumClassComponent classComponent;
	private EnumTypeComponent typeComponent;

	// --- Getters & Setters ---
	public EnumClassComponent getClassComponent() {
		return classComponent;
	}
	public void setClassComponent(EnumClassComponent classComponent) {
		this.classComponent = classComponent;
	}
	public EnumTypeComponent getTypeComponent() {
		return typeComponent;
	}
	public void setTypeComponent(EnumTypeComponent typeComponent) {
		this.typeComponent = typeComponent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// --- Constructors ---
	public Component(int idProduct, String nameP, Float price, String descriptionP, int stock, String brand,
			String model, String color, boolean saleActive, Float salePercentage, boolean isActive,
			EnumClassComponent classComponent, EnumTypeComponent typeComponent) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
		this.classComponent = classComponent;
		this.typeComponent = typeComponent;
	}
	
	public Component() {
		super();
	}

	
	
}
