package model;

/**
 * @author Ander
 * 
 *         An enumeration representing the different possible statuses for a
 *         purchase.
 *         <p>
 *         This enumeration defines the following possible statuses:
 *         </p>
 *         <p>
 *         Each status has a corresponding label that can be retrieved using the
 *         {@link #getLabel()} method.
 *         </p>
 */
public enum EnumStatusPurchase {
	IN_PROGRESS("In progress"), FINISHED("Finished");

	private final String label;

	/**
	 * Constructs a new EnumStatusPurchase instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumStatusPurchase(String label) {
		this.label = label;
	}

	/**
	 * Returns the label corresponding to this status.
	 * 
	 * @return the label for this status
	 */
	public String getLabel() {
		return label;
	}

}
