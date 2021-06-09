package sopra.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;
import sopra.formation.model.Views;
import sopra.formation.repository.ISalleRepository;

@RestController
@RequestMapping("/salle")
@CrossOrigin("*")
public class SalleRestController {

	@Autowired
	private ISalleRepository salleRepo;

	@GetMapping("")
	@JsonView(Views.ViewSalle.class)
	public List<Salle> findAll() {
		return salleRepo.findAll();
	}

	@GetMapping("/by-filiere/{idFiliere}")
	@JsonView(Views.ViewSalle.class)
	public List<Salle> findAllByFiliere(@PathVariable Long idFiliere) {
		return salleRepo.findAllByFiliere(idFiliere);
	}

	@GetMapping("/by-ville/{ville}")
	@JsonView(Views.ViewSalle.class)
	public List<Salle> findAllByVille(@PathVariable String ville) {
		return salleRepo.findAllByVille(ville);
	}

	@GetMapping("/{nom}:{capacite}")
	@JsonView(Views.ViewSalle.class)
	public Salle find(@PathVariable String nom, @PathVariable Integer capacite) {
		SalleId id = new SalleId(nom, capacite);

		Optional<Salle> optSalle = salleRepo.findById(id);

		if (optSalle.isPresent()) {
			return optSalle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSalle.class)
	public Salle create(@RequestBody Salle salle) {
		salle = salleRepo.save(salle);

		return salle;
	}

	@PutMapping("/{nom}:{capacite}")
	@JsonView(Views.ViewSalle.class)
	public Salle update(@RequestBody Salle salle, @PathVariable String nom, @PathVariable Integer capacite) {
		SalleId id = new SalleId(nom, capacite);

		if (!salleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		salle = salleRepo.save(salle);

		return salle;
	}

	@DeleteMapping("/{nom}:{capacite}")
	public void delete(@PathVariable String nom, @PathVariable Integer capacite) {
		SalleId id = new SalleId(nom, capacite);

		salleRepo.deleteById(id);
	}
}
