package model;

/**
 * @author Jago
 * 
 *         Enum class for a subdivision of accessory, using a label to get
 *         around the "nonElectric" value and read it as "Non-electric"
 */
public enum EnumClassAccessory {
	ELECTRIC("Electric"), NONELECTRIC("Non-electric");

	private final String label;

	EnumClassAccessory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public static EnumClassAccessory getValue(String label) {
		EnumClassAccessory enumValue = null;

		if (label.equalsIgnoreCase("Electric")) {
			enumValue = EnumClassAccessory.ELECTRIC;
		}else if (label.equalsIgnoreCase("Non-electric")) {
			enumValue = EnumClassAccessory.NONELECTRIC;
		}
		
		return enumValue;
	}
}
