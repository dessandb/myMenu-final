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

import org.springframework.data.annotation.Version;
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "Nom")
	private String nom;
	@Column(name = "Prenom")
	private String prenom;
	@Column(name = "Poids_kg")
	private Float poids;
	@Column(name = "Taille")
	private Float taille;
	@OneToMany(mappedBy="utilisateur")
	private List<PreferenceAlimentaire> preferencesAlimentaires = new ArrayList<PreferenceAlimentaire>();
	@Column(name = "Date_Naissance")
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@Column(name = "IMC")
	private Float imc;
	@Enumerated(EnumType.STRING)
	private PhysicalActivity physicalActivity;
	@OneToMany(mappedBy = "utilisateur")
	private List<Adresse> adresses = new ArrayList<Adresse>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Planning> plannings = new ArrayList<Planning>();
	
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, Float poids, Float taille, Date dateNaissance, Genre genre, Float imc,
			PhysicalActivity physicalActivity) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.poids = poids;
		this.taille = taille;
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
	
	
	
	
	
	

}
