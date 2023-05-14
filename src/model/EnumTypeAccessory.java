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
	
	public static EnumTypeAccessory getValue(String label) {
		EnumTypeAccessory enumValue = null;

		if (label == "Audio") {
			enumValue = EnumTypeAccessory.Audio;
		}else if (label == "Connection") {
			enumValue = EnumTypeAccessory.Connection;
		}else if (label == "Item") {
			enumValue = EnumTypeAccessory.Item;
		}
		
		return enumValue;
	}
}
