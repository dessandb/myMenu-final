package sopra.myMenu.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import sopra.formation.model.Stagiaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/stagiaire")
@CrossOrigin("*")
public class StagiaireRestController {

	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public List<Stagiaire> findAll() {
		return personneRepo.findAllStagiaire();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewStagiaireDetail.class)
	public Stagiaire find(@PathVariable Long id) {
		Optional<Stagiaire> optStagiaire = personneRepo.findStagiaireByIdWithEvaluationAndFiliere(id);

		if (optStagiaire.isPresent()) {
			return optStagiaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire create(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid");
		}

		stagiaire = personneRepo.save(stagiaire);

		return stagiaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire update(@RequestBody Stagiaire stagiaire, @PathVariable Long id) {
		if (!personneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		stagiaire = personneRepo.save(stagiaire);

		return stagiaire;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneRepo.deleteById(id);
	}
}
