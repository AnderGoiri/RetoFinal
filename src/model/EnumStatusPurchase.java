package model;

/**
 * @author Ander
 * 
 *         An enumeration representing the different possible statuses for a
 *         purchase.
 *         <p>
 *         This enumeration defines the following possible statuses:
 *         </p>
 *         <ul>
 *         <li><code>New</code>: the purchase has just been created and the
 *         Payment method has not been specified</li>
 *         <li><code>Pending Payment</code>: the Payment method has been
 *         specified but the Payment is yet to be done</li>
 *         <li><code>Payment Received</code>: The Payment has been received</li>
 *         <li><code>Payment Accepted</code>: the Payment has been accepted</li>
 *         <li><code>Payment Denied</code>: the Payment has been denied</li>
 *         <li><code>Cancelled</code>: the purchase has been cancelled</li>
 *         <li><code>Closed</code>: the purchase transaction has ended</li>
 *         </ul>
 *         <p>
 *         Each status has a corresponding label that can be retrieved using the
 *         {@link #getLabel()} method.
 *         </p>
 */
public enum EnumStatusPurchase {
	NEW("New"), PENDING_PAYMENT("Pending"), PAYMENT_RECEIVED("Payment Received"), PAYMENT_ACCEPTED("Payment Accepted"),
	PAYMENT_DENIED("Payment Denied"), CANCELLED("Cancelled"), CLOSED("Closed");

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
