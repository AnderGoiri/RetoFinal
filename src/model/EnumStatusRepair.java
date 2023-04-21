package model;

/**
 * 
 * @author Ander
 * 
 *         An enumeration representing the different possible statuses for a
 *         repair process.
 *         <p>
 *         This enumeration defines the following possible statuses:
 *         </p>
 *         <ul>
 *         <li><code>Pending</code>: The repair request has been received and is awaiting
 *         review.</li>
 *         <li><code>In progress</code>: The repair is currently being worked on.</li>
 *         <li><code>Cancelled</code>: The repair request has been cancelled.</li>
 *         <li><code>Accepted</code>: The repair request has been accepted and will be worked
 *         on.</li>
 *         <li><code>Denied</code>: The repair request has been denied and will not be worked
 *         on.</li>
 *         <li><code>Finished</code>: The repair process has been completed.</li>
 *         </ul>
 *         <p>
 *         Each status has a corresponding label that can be retrieved using the
 *         {@link #getLabel()} method.
 *         </p>
 *
 */
public enum EnumStatusRepair {
	PENDING("Pending"), IN_PROGRESS("In progress"), CANCELLED("Cancelled"), ACCEPTED("Accepted"), DENIED("Denied"),
	FINISHED("Finished");

	private final String label;

	/**
	 * Constructs a new EnumStatusRepair instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumStatusRepair(String label) {
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
