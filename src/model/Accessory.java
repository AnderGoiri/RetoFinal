package model;

import java.util.Set;

/**
 * @author Jago Derived class Accessory from Product
 */
public class Accessory extends Product {

	// --- Attributes ---
	private static final long serialVersionUID = 1L;
	private EnumClassAccessory classAccessory;
	private EnumTypeAccessory typeAccessory;

	// --- Getters & Setters ---
	public EnumClassAccessory getClassAccessory() {
		return classAccessory;
	}

	public void setClassAccessory(EnumClassAccessory classAccessory) {
		this.classAccessory = classAccessory;
	}

	public EnumTypeAccessory getTypeAccessory() {
		return typeAccessory;
	}

	public void setTypeAccessory(EnumTypeAccessory typeAccessory) {
		this.typeAccessory = typeAccessory;
	}

	// --- Constructors ---
	public Accessory(int idProduct, String nameP, Float price, String descriptionP, int stock, Set<String> brand,
			Set<String> model, Set<String> color, boolean saleActive, Float salePercentage, boolean isActive,
			EnumClassAccessory classAccessory, EnumTypeAccessory typeAccessory) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
		this.classAccessory = classAccessory;
		this.typeAccessory = typeAccessory;
	}

	public Accessory(int idProduct, String nameP, Float price, String descriptionP, int stock, Set<String> brand,
			Set<String> model, Set<String> color, boolean saleActive, Float salePercentage, boolean isActive) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
	}

}
