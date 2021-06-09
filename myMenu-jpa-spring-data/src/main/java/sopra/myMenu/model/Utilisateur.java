package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Version;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "Nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(name = "Prenom")
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Column(name = "Poids_kg")
	@JsonView(Views.ViewCommon.class)
	private Float poids;
	@Column(name = "Taille")
	@JsonView(Views.ViewCommon.class)
	private Float taille;
	@Column(name = "Email")
	@JsonView(Views.ViewCommon.class)
	private String email;
	@Column(name = "Telephone")
	@JsonView(Views.ViewCommon.class)
	private String telephone;
	@OneToMany(mappedBy="utilisateur")
	private List<PreferenceAlimentaire> preferencesAlimentaires = new ArrayList<PreferenceAlimentaire>();
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewCommon.class)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Genre genre;
	@Column(name = "IMC")
	@JsonView(Views.ViewCommon.class)
	private Float imc;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private PhysicalActivity physicalActivity;
	@OneToMany(mappedBy = "utilisateur")
	private List<Adresse> adresses = new ArrayList<Adresse>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Planning> plannings = new ArrayList<Planning>();
	
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(Long id, int version, String nom, String prenom, Float poids, Float taille, String email,
			String telephone, Date dateNaissance, Genre genre, Float imc, PhysicalActivity physicalActivity) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.poids = poids;
		this.taille = taille;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.imc = imc;
		this.physicalActivity = physicalActivity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	

	public List<PreferenceAlimentaire> getPreferencesAlimentaires() {
		return preferencesAlimentaires;
	}

	public void setPreferencesAlimentaires(List<PreferenceAlimentaire> preferencesAlimentaires) {
		this.preferencesAlimentaires = preferencesAlimentaires;
	}

	

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public PhysicalActivity getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(PhysicalActivity physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	
	public void addAdresse(Adresse adr ) {
		adresses.add(adr);
	}
	
	public void addPreferenceAlimentaire(PreferenceAlimentaire prefAlim ) {
		preferencesAlimentaires.add(prefAlim);
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	
	
	

}
