package model;
/**
 * Enum class for a subdivision of components
 * 
 * @author Ander Goirigolzarri Iturburu
 */
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
	
	public static EnumTypeComponent getValue(String label) {
		EnumTypeComponent enumValue = null;

		if (label.equalsIgnoreCase("Architecture")) {
			enumValue = EnumTypeComponent.ARCHITECTURE;
		}else if (label.equalsIgnoreCase("Tuning")) {
			enumValue = EnumTypeComponent.TUNING;
		}else if (label.equalsIgnoreCase("Connection")) {
			enumValue = EnumTypeComponent.CONNECTION;
		}
		
		return enumValue;
	}
}
