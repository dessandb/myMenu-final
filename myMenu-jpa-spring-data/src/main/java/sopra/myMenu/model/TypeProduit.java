package sopra.myMenu.model;

public enum TypeProduit {
 
	 SAUCE("SAUCE"), LEGUMES("LEGUMES"), FROMAGE("FROMAGE"), SURGELES("SURGELES"), VIANDE("VIANDE"), EPICES("EPICES"), BOISSON("BOISSON");
	
	private final String label;

	private TypeProduit(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
