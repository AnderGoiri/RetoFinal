package model;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Jago Base abstract class Product, can't instantiate it because it has
 *         three derived classes
 */
public abstract class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int idProduct;
	protected String nameP;
	protected Float price;
	protected String descriptionP;
	protected int stock;
	protected Set<String> brand;
	protected Set<String> model;
	protected Set<String> color;
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

	public Set<String> getBrand() {
		return brand;
	}

	public void setBrand(Set<String> brand) {
		this.brand = brand;
	}

	public Set<String> getModel() {
		return model;
	}

	public void setModel(Set<String> model) {
		this.model = model;
	}

	public Set<String> getColor() {
		return color;
	}

	public void setColor(Set<String> color) {
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

	// --- Constructors ---
	public Product(int idProduct, String nameP, Float price, String descriptionP, int stock, Set<String> brand,
			Set<String> model, Set<String> color, boolean saleActive, Float salePercentage, boolean isActive) {
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
