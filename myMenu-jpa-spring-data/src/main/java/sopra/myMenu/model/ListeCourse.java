package sopra.myMenu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

@Entity
@Table(name="ListeCourse")
public class ListeCourse {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AjustementQuantite_id") 
	private AjustementQuantite ajustementQuantite;
	
	public ListeCourse() {
		super(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AjustementQuantite getAjustementQuantite() {
		return ajustementQuantite;
	}

	public void setAjustementQuantite(AjustementQuantite ajustementQuantite) {
		this.ajustementQuantite = ajustementQuantite;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
