package sopra.myMenu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "objectifs")
public class Objectif {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TypeObjectif typeObjectif;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "nombreRepasParJour")
	private int nombreRepasParJour;
	@Column(name = "nombreCaloriesParSemaine")
	private int nombreCaloriesParSemaine;
	
	public Objectif() {
		super();
	}
	
	public Objectif(TypeObjectif typeObjectif, String commentaire, int nombreRepasParJour,
			int nombreCaloriesParSemaine) {
		super();
		this.typeObjectif = typeObjectif;
		this.commentaire = commentaire;
		this.nombreRepasParJour = nombreRepasParJour;
		this.nombreCaloriesParSemaine = nombreCaloriesParSemaine;
	}
	
	public Objectif(Long id, TypeObjectif typeObjectif, String commentaire, int nombreRepasParJour,
			int nombreCaloriesParSemaine) {
		super();
		this.id = id;
		this.typeObjectif = typeObjectif;
		this.commentaire = commentaire;
		this.nombreRepasParJour = nombreRepasParJour;
		this.nombreCaloriesParSemaine = nombreCaloriesParSemaine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeObjectif getTypeObjectif() {
		return typeObjectif;
	}

	public void setTypeObjectif(TypeObjectif typeObjectif) {
		this.typeObjectif = typeObjectif;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNombreRepasParJour() {
		return nombreRepasParJour;
	}

	public void setNombreRepasParJour(int nombreRepasParJour) {
		this.nombreRepasParJour = nombreRepasParJour;
	}

	public int getNombreCaloriesParSemaine() {
		return nombreCaloriesParSemaine;
	}

	public void setNombreCaloriesParSemaine(int nombreCaloriesParSemaine) {
		this.nombreCaloriesParSemaine = nombreCaloriesParSemaine;
	}
	
}
