package sopra.myMenu.model;

public enum PhysicalActivity {
	PANTOUFLARD("PANTOUFLARD"),OCCASIONNEL("OCCASIONNEL"),REGULIER("REGULIER"),INTENSIF("INTENSIF"),PROFESSIONNEL("PROFESSIONNEL");
	
	private final String label;

	private PhysicalActivity(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
