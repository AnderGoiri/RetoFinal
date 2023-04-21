package model;

public enum EnumTypeComponent {
	ARCHITECTURE("Architecture"), TUNING("Tuning"), CONNECTION("Connection");

	private final String label;

	/**
	 * Constructs a new EnumTypeComponent instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumTypeComponent(String label) {
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
