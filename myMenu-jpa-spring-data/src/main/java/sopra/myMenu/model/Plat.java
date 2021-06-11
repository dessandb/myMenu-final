package sopra.myMenu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "plat")
public class Plat {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "nombre_personne")
	@JsonView(Views.ViewCommon.class)
	private int nombrePersonne;
	@ManyToOne
	@JoinColumn(name = "repas_id")
	@JsonView(Views.ViewCommon.class)
	private Repas repas;
	@OneToOne
	@JoinColumn(name= "recette_id")
	@JsonIgnore
	private Recette recette;
	
	public Plat() {
		super();
	}


	public Plat(int nombrePersonne) {
		super();
		this.nombrePersonne = nombrePersonne;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNombrePersonne() {
		return nombrePersonne;
	}


	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}


	public Repas getRepas() {
		return repas;
	}


	public void setRepas(Repas repas) {
		this.repas = repas;
	}


	public Recette getRecette() {
		return recette;
	}


	public void setRecette(Recette recette) {
		this.recette = recette;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
}
