package sopra.myMenu.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

@Entity
@Table(name = "menu")
public class Menu {
		@Id
		@GeneratedValue
		private Long id;
		@Version
		private int version;
		@Column(name = "jour")
		private Date jour;
		@Column(name = "periode")
		private Duration periode;
		@OneToMany(mappedBy = "menu")
		private List<Repas> repas = new ArrayList<Repas>();
		@ManyToOne
		@JoinColumn(name = "planning_id")
		private Planning planning;
		
		//private final Duration = Duration.of(1, WEEKS);
		
		public Menu() {
			super();
		}
		
		public Menu(Duration periode) {
			super();
			this.periode = periode;
		}
		
		public Menu(Long id, Duration periode) {
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
		

		public Date getJour() {
			return jour;
		}

		public void setJour(Date jour) {
			this.jour = jour;
		}

		public Duration getPeriode() {
			return periode;
		}

		public void setPeriode(Duration periode) {
			this.periode = periode;
		}

		public List<Repas> getRepas() {
			return repas;
		}

		public void setRepas(List<Repas> repas) {
			this.repas = repas;
		}

		public Planning getPlanning() {
			return planning;
		}

		public void setPlanning(Planning planning) {
			this.planning = planning;
		}	
			
		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
}
