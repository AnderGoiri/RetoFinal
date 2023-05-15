package model;
/**
 * @author Jago
 * Enum class for the types of Accessory
 */
public enum EnumTypeAccessory {
	AUDIO("Audio"), CONNECTION("Connection"), ITEM("Item");
	
	private final String label;
	
	EnumTypeAccessory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public static EnumTypeAccessory getValue(String label) {
		EnumTypeAccessory enumValue = null;

		if (label.equalsIgnoreCase("Audio")) {
			enumValue = EnumTypeAccessory.AUDIO;
		}else if (label.equalsIgnoreCase("Connection")) {
			enumValue = EnumTypeAccessory.CONNECTION;
		}else if (label.equalsIgnoreCase("Item")) {
			enumValue = EnumTypeAccessory.ITEM;
		}
		
		return enumValue;
	}
	
	
}
