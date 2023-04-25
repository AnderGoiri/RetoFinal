package model;

import java.util.Set;

/**
 * @author Jago, Ander Derived class Instrument from Product
 */
public class Instrument extends Product {

	// --- Attributes ---
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

	// --- Constructors ---
	public Instrument(int idProduct, String nameP, Float price, String descriptionP, int stock, Set<String> brand,
			Set<String> model, Set<String> color, boolean saleActive, Float salePercentage, boolean isActive,
			EnumClassInstrument classInstrument, EnumTypeInstrument typeInstrument) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
		this.classInstrument = classInstrument;
		this.typeInstrument = typeInstrument;
	}

	public Instrument(int idProduct, String nameP, Float price, String descriptionP, int stock, Set<String> brand,
			Set<String> model, Set<String> color, boolean saleActive, Float salePercentage, boolean isActive) {
		super(idProduct, nameP, price, descriptionP, stock, brand, model, color, saleActive, salePercentage, isActive);
	}

}
