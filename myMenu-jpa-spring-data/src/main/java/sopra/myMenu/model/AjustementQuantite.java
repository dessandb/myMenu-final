package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="AjustementQuantite")
public class AjustementQuantite {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "quantiteModifiee")
	@JsonView(Views.ViewCommon.class)
	private Float quantiteModifiee;
	@OneToMany(mappedBy = "ajustementQuantite")
	private List<ListeCourse> listeCourse=new ArrayList<ListeCourse>();
	@OneToMany(mappedBy = "ajustementQuantite")
	private List<Ingredient> ingredients=new ArrayList<Ingredient>();
	
	
	public AjustementQuantite() {
		super();
	}
	
	public AjustementQuantite(Float quantiteModifiee) {
		super();
		this.quantiteModifiee = quantiteModifiee;
	}
	public Long getId() {
		return id;
	}
	public Float getQuantiteModifiee() {
		return quantiteModifiee;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuantiteModifiee(Float quantiteModifiee) {
		this.quantiteModifiee = quantiteModifiee;
	}

	public List<ListeCourse> getListeCourse() {
		return listeCourse;
	}

	public void setListeCourse(List<ListeCourse> listeCourse) {
		this.listeCourse = listeCourse;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	
	
	

}
