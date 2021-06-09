package sopra.myMenu.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "planning")
public class Planning {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@Column(name = "periode")
	@JsonView(Views.ViewCommon.class)
	private Integer periode;
	
	@OneToMany(mappedBy = "planning")
	@JsonIgnore
	private List<Menu> menus = new ArrayList<Menu>(); 
	
	@OneToOne
	@JoinColumn(name = "Objectif_Id")
	@JsonView(Views.ViewPlanningWithObjectif.class)
	private Objectif objectif;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	@JsonView(Views.ViewPlanningWithUtilisateur.class)
	private Utilisateur utilisateur;
	
	public Planning() {
		super();
	}
	
	public Planning(Integer periode) {
		super();
		this.periode = periode;
	}
	
	public Planning(Long id, Integer periode) {
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

	public Integer getPeriode() {
		return periode;
	}

	public void setPeriode(Integer periode) {
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
