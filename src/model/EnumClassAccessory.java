package model;
/**
 * @author Jago
 * Enum class for a subdivision of accessory, using a label to get around the "nonElectric" value and read it as "Non-electric"
 */
public enum EnumClassAccessory {
	Electric("Electric"), nonElectric("Non-electric");

	private final String label;
	
	EnumClassAccessory(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
