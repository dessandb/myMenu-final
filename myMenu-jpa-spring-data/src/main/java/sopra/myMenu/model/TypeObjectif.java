package sopra.myMenu.model;

public enum TypeObjectif {

		PERTE_POIDS("PERTE_POIDS"), BIEN_ETRE("BIEN_ETRE"), PRISE_MASSE("PRISE_MASSE");
	
	private final String label;

	private TypeObjectif(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
