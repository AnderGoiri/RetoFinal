package model;

public enum EnumClassInstrument {
	WIND("Wind"), STRING("String"), PERCUSSION("Percussion");

	private final String label;

	/**
	 * Constructs a new EnumClassInstrument instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumClassInstrument(String label) {
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
