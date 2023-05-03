package model;
/**
 * 
 * @author Ander
 * Enum class for a subdivision of components
 *
 */
public enum EnumClassComponent {
	CHASIS("Chasis"), CIRCUIT("Circuit");

	private final String label;

	/**
	 * Constructs a new EnumClassComponent instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumClassComponent(String label) {
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