package model;

/**
 * Derived class Accessory from Product
 * 
 * @author Jago Bartolomé Barroso
 */
public class Accessory extends Product {
	// ---Attributes---
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// --- Constructors ---
	public Accessory(int idProduct, String nameP, Float price, String descriptionP, int stock, String brand,
			String model, String color, boolean saleActive, Float salePercentage, boolean isActive,
			EnumClassAccessory classAccessory, EnumTypeAccessory typeAccessory) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
		this.classAccessory = classAccessory;
		this.typeAccessory = typeAccessory;
		}


	public Accessory() {
		super();
	}

}
