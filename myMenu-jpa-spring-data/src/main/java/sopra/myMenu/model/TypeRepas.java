package sopra.myMenu.model;

public enum TypeRepas {
	
	PETIT_DEJ("PETIT_DEJ"), DEJ("DEJ"), DINNER("DINNER");
	
	private final String label;

	private TypeRepas(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
