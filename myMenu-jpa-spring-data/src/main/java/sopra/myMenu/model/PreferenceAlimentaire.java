package sopra.myMenu.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "preference_alimentaire")
public class PreferenceAlimentaire {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeAlimentation typeAlimentation;
	@ManyToOne
	@JoinColumn(name = "Utilisateur_Id")
	@JsonView(Views.ViewPreferenceAlimentaireWithUtilisateur.class)
	private Utilisateur utilisateur;
	
	public PreferenceAlimentaire() {
		super();
	}

	public PreferenceAlimentaire(TypeAlimentation typeAlimentation, Utilisateur utilisateur) {
		super();
		this.typeAlimentation = typeAlimentation;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TypeAlimentation getTypeAlimentation() {
		return typeAlimentation;
	}


	public void setTypeAlimentation(TypeAlimentation typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
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
