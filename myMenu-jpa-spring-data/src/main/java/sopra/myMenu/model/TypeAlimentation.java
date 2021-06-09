package sopra.myMenu.model;

public enum TypeAlimentation {
	NONE("None"),VEGAN("VEGAN"),HALAL("HALAL"),VEGETARIEN("VEGETARIEN");
	
	private final String label;

	private TypeAlimentation(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
