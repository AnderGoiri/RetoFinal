package model;

import java.time.LocalDate;

/**
 * @author Jago
 * Class that registers a user action on a product
 */
public class Management {
	private int idManagement;
	private EnumAction actionType;
	private String descriptionM;
	private LocalDate date;
	private String idUser;
	private String idProduct;
}
