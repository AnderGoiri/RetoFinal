package model;
/**
 * @author Jago
 * Enum class for the types of Accessory
 */
public enum EnumTypeAccessory {
	Audio("Audio"), Connection("Connection"), Item("Item");
	
	private final String label;
	
	EnumTypeAccessory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
