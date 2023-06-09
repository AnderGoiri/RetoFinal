package model;

import java.time.LocalDate;
import java.util.Set;

/**
 * The <code>Purchase</code> class represents a purchase made by a
 * <code>User</code> in the system. It contains information such as the ID of
 * the purchase, the ID of the user who made the purchase, the purchase
 * quantity, the total cost of the purchase, the date of the purchase, the
 * current status of the purchase, the method of purchase, and a set of products
 * included in the purchase.
 * 
 * @author Jago Bartolomé Barroso
 * @author Ander Goirigolzarri Iturburu
 */
public class Purchase {

	// --- Attributes ---
	private int idPurchase;
	private int idUser;
	private int purchaseQuantity;
	private float purchaseTotalCost;
	private LocalDate purchaseDate;
	private EnumStatusPurchase statusPurchase;
	private Set<Product> setProduct;

	public Purchase(int idPurchase, int idUser, int purchaseQuantity, float purchaseTotalCost, LocalDate purchaseDate,
			EnumStatusPurchase statusPurchase, Set<Product> setProduct) {
		super();
		this.idPurchase = idPurchase;
		this.idUser = idUser;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseTotalCost = purchaseTotalCost;
		this.purchaseDate = purchaseDate;
		this.statusPurchase = statusPurchase;
		this.setProduct = setProduct;
	}


	public Purchase() {
		super();
	}

	// --- Getters & Setters ---

	public int getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(int idPurchase) {
		this.idPurchase = idPurchase;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public float getPurchaseTotalCost() {
		return purchaseTotalCost;
	}

	public void setPurchaseTotalCost(float purchaseTotalCost) {
		this.purchaseTotalCost = purchaseTotalCost;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public EnumStatusPurchase getStatusPurchase() {
		return statusPurchase;
	}

	public void setStatusPurchase(EnumStatusPurchase statusPurchase) {
		this.statusPurchase = statusPurchase;
	}

	public Set<Product> getSetProduct() {
		return setProduct;
	}

	public void setSetProduct(Set<Product> setProduct) {
		this.setProduct = setProduct;
	}

}