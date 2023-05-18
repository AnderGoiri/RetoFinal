package model;

/**
 * Derived class Instrument from Product
 * 
 * @author Jago Bartolomé Barroso
 */

public class Instrument extends Product {
	// ---Attributes---
	private static final long serialVersionUID = 1L;
	private EnumClassInstrument classInstrument;
	private EnumTypeInstrument typeInstrument;

	// --- Getters & Setters ---
	public EnumClassInstrument getClassInstrument() {
		return classInstrument;
	}

	public void setClassInstrument(EnumClassInstrument classInstrument) {
		this.classInstrument = classInstrument;
	}

	public EnumTypeInstrument getTypeInstrument() {
		return typeInstrument;
	}

	public void setTypeInstrument(EnumTypeInstrument typeInstrument) {
		this.typeInstrument = typeInstrument;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// --- Constructors ---
	public Instrument(int idProduct, String nameP, Float price, String descriptionP, int stock, String brand,
			String model, String color, boolean saleActive, int salePercentage, boolean isActive,
			EnumClassInstrument classInstrument, EnumTypeInstrument typeInstrument) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
		this.classInstrument = classInstrument;
		this.typeInstrument = typeInstrument;
	}

	public Instrument(String nameP, String model, String descriptionP, float price, int stock, boolean isActive,
			boolean isSale, int salePercentage, String color, String brand, EnumClassInstrument classInstrument,
			EnumTypeInstrument typeInstrument) {
		super(nameP, model, descriptionP, price, stock, isActive, isSale, salePercentage, color, brand);
		this.classInstrument = classInstrument;
		this.typeInstrument = typeInstrument;
	}

	public Instrument() {
		super();
	}
}
