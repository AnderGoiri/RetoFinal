package model;

/**
 *
 * Defines an enumeration for the different states of a <code>Manager</code>
 * object during the registration process.
 * <p>
 * A new <code>User</code> that wants to be registered as a <code>Manager</code>
 * needs to have their registration request validated by another
 * <code>Manager</code>.
 * 
 * When a new <code>User</code> sends a registration request, the default status
 * applied will be <code><i>"Pending"</i></code>. The status of the request
 * needs to be changed to <code><i>"Yes"</i></code> or <code><i>"No"</i></code>
 * by a <code>Manager</code> with the isAdmin boolean attribute set to true.
 * </p>
 * 
 * @author Ander Goirigolzarri Iturburu
 * 
 */
public enum EnumStatusManager {
	P("Pending"), A("Approved"), R("Rejected");

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

	public static EnumStatusManager getValue(String label) {
		EnumStatusManager enumValue = null;

		if (label == "Pending") {
			enumValue = EnumStatusManager.P;
		}else if (label == "Approved") {
			enumValue = EnumStatusManager.A;
		}else if (label == "Rejected") {
			enumValue = EnumStatusManager.R;
		}
		return enumValue;
	}

}
