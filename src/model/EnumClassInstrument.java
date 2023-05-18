package model;

/**
 * Enum class for a subdivision of instruments
 * 
 * @author Ander Goirigolzarri Iturburu
 */
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

	public static EnumClassInstrument getValue(String label) {
		EnumClassInstrument enumValue = null;

		if (label.equalsIgnoreCase("Wind")) {
			enumValue = EnumClassInstrument.WIND;
		} else if (label.equalsIgnoreCase("String")) {
			enumValue = EnumClassInstrument.STRING;
		} else if (label.equalsIgnoreCase("Percussion")) {
			enumValue = EnumClassInstrument.PERCUSSION;
		}
		return enumValue;
	}
}
