package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "nom")
	@JsonView(Views.ViewIngredient.class)
	private String nom;
	@Column(name = "quantite")
	@JsonView(Views.ViewCommon.class)
	private Float quantite;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewIngredient.class)
	private TypeProduit typeProduit;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewIngredient.class)
	private ProduitSaison produitSaison;
	@JsonIgnore
	@Column(name = "nombre_calories_100g")
	private Float nombreCalories100g;
	
	@ManyToMany 
	@JoinTable(name = "recettes", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "recette_id"))
	private List<Recette> recettes = new ArrayList<Recette>();
	@ManyToOne
	@JoinColumn(name = "AjustementQuantite_id")
	private AjustementQuantite ajustementQuantite;
	@ManyToOne
	@JoinColumn(name = "magasinIngredient_id")
	private MagasinIngredient magasinIngredient;
	public Ingredient() {
		super();
	}


	public Ingredient(String nom, float quantite, TypeProduit typeProduit, ProduitSaison produitSaison,
			float nombreCalories100g) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.typeProduit = typeProduit;
		this.produitSaison = produitSaison;
		this.nombreCalories100g = nombreCalories100g;
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


	public Float getQuantite() {
		return quantite;
	}


	public void setQuantite(Float quantite) {
		this.quantite = quantite;
	}


	public TypeProduit getTypeProduit() {
		return typeProduit;
	}


	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}


	public ProduitSaison getProduitSaison() {
		return produitSaison;
	}


	public void setProduitSaison(ProduitSaison produitSaison) {
		this.produitSaison = produitSaison;
	}


	public Float getNombreCalories100g() {
		return nombreCalories100g;
	}


	public void setNombreCalories100g(Float nombreCalories100g) {
		this.nombreCalories100g = nombreCalories100g;
	}

	public List<Recette> getRecettes() {
		return recettes;
	}


	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}


	public AjustementQuantite getAjustementQuantite() {
		return ajustementQuantite;
	}


	public void setAjustementQuantite(AjustementQuantite ajustementQuantite) {
		this.ajustementQuantite = ajustementQuantite;
	}


	public MagasinIngredient getMagasinIngredient() {
		return magasinIngredient;
	}


	public void setMagasinIngredient(MagasinIngredient magasinIngredient) {
		this.magasinIngredient = magasinIngredient;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	


	
	
	
	

}
