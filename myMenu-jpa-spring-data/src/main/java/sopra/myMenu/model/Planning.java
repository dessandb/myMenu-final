package sopra.myMenu.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

@Entity
@Table(name = "planning")
public class Planning {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "periode")
	private Duration periode;
	@OneToMany(mappedBy = "planning")
	private List<Menu> menus = new ArrayList<Menu>(); 
	@OneToOne
	@JoinColumn(name = "Objectif_Id")
	private Objectif objectif;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Planning() {
		super();
	}
	
	public Planning(Duration periode) {
		super();
		this.periode = periode;
	}
	
	public Planning(Long id, Duration periode) {
		super();
		this.id = id;
		this.periode = periode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Duration getPeriode() {
		return periode;
	}

	public void setPeriode(Duration periode) {
		this.periode = periode;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
