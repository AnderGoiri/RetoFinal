package model;

/**
 * @author Ander
 *
 *         Defines an enumeration for the different states of a <code>Manager</code>
 *         object during the registration process.
 *         <p>
 *         A new <code>User</code> that wants to be registered as a <code>Manager</code>
 *         needs to have their registration request validated by another
 *         <code>Manager</code>.
 * 
 *         When a new <code>User</code> sends a registration request, the default
 *         status applied will be <code><i>"Pending"</i></code>. The status of the request
 *         needs to be changed to <code><i>"Yes"</i></code> or <code><i>"No"</i></code> by a
 *         <code>Manager</code> with the isAdmin boolean attribute set to true.
 *         </p>
 */
public enum EnumStatusManager {
	P("Pending"), Y("Yes"), N("No");

	private final String label;

	/**
	 * Constructs a new EnumStatusManager instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumStatusManager(String label) {
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
