package model;

import java.io.Serializable;
import java.util.Set;

import exceptions.AccessoryNotFoundException;
import exceptions.ComponentNotFoundException;
import exceptions.InstrumentNotFoundException;

/**
 * @author Jago
 * Base abstract class Product, can't instantiate it because it has three derived classes
 */
public abstract class Product implements Serializable {

	// ---Attributes---
	private static final long serialVersionUID = 1L;
	protected int idProduct;
	protected String nameP;
	protected Float price;
	protected String descriptionP;
	protected int stock;
	protected String brand;
	protected String model;
	protected String color;
	protected boolean saleActive;
	protected Float salePercentage;
	protected boolean isActive;
	
	// --- Getters & Setters ---
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescriptionP() {
		return descriptionP;
	}
	public void setDescriptionP(String descriptionP) {
		this.descriptionP = descriptionP;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isSaleActive() {
		return saleActive;
	}
	public void setSaleActive(boolean saleActive) {
		this.saleActive = saleActive;
	}
	public Float getSalePercentage() {
		return salePercentage;
	}
	public void setSalePercentage(Float salePercentage) {
		this.salePercentage = salePercentage;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Instrument getInstrument() throws InstrumentNotFoundException{
		if (this instanceof Instrument) {
			return (Instrument) this;
		} else {
			throw new InstrumentNotFoundException();
		}
	}
	
	public Component getComponent() throws ComponentNotFoundException{
		if (this instanceof Instrument) {
			return (Component) this;
		} else {
			throw new ComponentNotFoundException();
		}
	}
	
	public Accessory getAccessory() throws AccessoryNotFoundException{
		if (this instanceof Instrument) {
			return (Accessory) this;
		} else {
			throw new AccessoryNotFoundException();
		}
	}
	// --- Constructors ---
	public Product(int idProduct, String nameP, Float price, String descriptionP, int stock, String brand, String model,
			String color, boolean saleActive, Float salePercentage, boolean isActive) {
		super();
		this.idProduct = idProduct;
		this.nameP = nameP;
		this.price = price;
		this.descriptionP = descriptionP;
		this.stock = stock;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.saleActive = saleActive;
		this.salePercentage = salePercentage;
		this.isActive = isActive;
	}
	
	public Product() {
		super();
	}
	
}
