package sopra.myMenu.model;

import javax.persistence.Embeddable;
@Embeddable
public class Coordonnees {
	private Double longitude;
	private Double latitude;
	
	public Coordonnees() {
		super();
	}

	public Coordonnees(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}
