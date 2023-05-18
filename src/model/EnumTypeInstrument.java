package model;
/**
 * 
 */
public enum EnumTypeInstrument {
	ACOUSTIC("Acoustic"),
	ELECTRONIC("Electronic");
	
	private final String label;

	/**
	 * Constructs a new EnumTypeInstrument instance with the specified label.
	 * 
	 * @param label the label corresponding to this status
	 */
	EnumTypeInstrument(String label) {
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
	
	public static EnumTypeInstrument getValue(String label) {
		EnumTypeInstrument enumValue = null;

		if (label.equalsIgnoreCase("Acoustic")) {
			enumValue = EnumTypeInstrument.ACOUSTIC;
		}else if (label.equalsIgnoreCase("Electronic")) {
			enumValue = EnumTypeInstrument.ELECTRONIC;
		}
		
		return enumValue;
	}
}
