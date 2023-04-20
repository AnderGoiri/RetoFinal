package model;

import java.time.LocalDate;
import java.util.Set;

public class Purchase {

	// ---Attributes---
	private int idPurchase;
	private int idUser;
	private int purchaseQuantity;
	private float purchaseTotalCost;
	private LocalDate purchaseDate;
	private EnumStatusPurchase statusPurchase;
	private String methodPurchase;
	private Set<Product> setProduct;

}