package sopra.myMenu.model;

public enum Genre {
	HOMME("HOMME"),FEMME("FEMME"),NON_BINAIRE("NON_BINAIRE");
	
	private final String label;

	private Genre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
