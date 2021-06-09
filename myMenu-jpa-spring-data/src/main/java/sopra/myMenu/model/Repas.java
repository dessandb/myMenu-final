package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.springframework.data.annotation.Version;

@Entity
@Table(name = "repas")
public class Repas {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	private TypeRepas typeRepas;
	@ManyToOne
	@JoinColumn(name = "menu")
	private Menu menu;
	@OneToMany(mappedBy = "repas")
	private List<Plat> plats = new ArrayList<Plat>();
	
	public Repas() {
		super();
	}
	
	public Repas(TypeRepas typeRepas) {
		super();
		this.typeRepas = typeRepas;
	}
	
	public Repas(Long id, TypeRepas typeRepas) {
		super();
		this.id = id;
		this.typeRepas = typeRepas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeRepas getTypeRepas() {
		return typeRepas;
	}

	public void setTypeRepas(TypeRepas typeRepas) {
		this.typeRepas = typeRepas;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
		
}
