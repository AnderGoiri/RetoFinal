package model;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Ander, Jago
 * 
 *         The <code>Purchase</code> class represents a purchase made by a
 *         <code>User</code> in the system. It contains information such as the
 *         ID of the purchase, the ID of the user who made the purchase, the
 *         purchase quantity, the total cost of the purchase, the date of the
 *         purchase, the current status of the purchase, the method of purchase,
 *         and a set of products included in the purchase.
 */
public class Purchase {

	// ---Attributes---
	private int idPurchase;
	private int idUser;
	private int purchaseQuantity;
	private float purchaseTotalCost;
	private LocalDate purchaseDate;
	private EnumStatusPurchase statusPurchase;
	private EnumMethodPurchase methodPurchase;
	private Set<Product> setProduct;

}