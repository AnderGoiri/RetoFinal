package model;

import java.io.Serializable;
import java.util.Set;

/**
 * Base abstract class Product, can't instantiate it because it has three derived classes
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
	
}
