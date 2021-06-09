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

import sopra.myMenu.model.Magasin;
import sopra.myMenu.model.Views;
import sopra.myMenu.model.Views.ViewMagasinWithMagasinIngredient;
import sopra.myMenu.repository.IMagasinRepository;

@RestController
@RequestMapping("/magasin")
@CrossOrigin("*")
public class MagasinRestController {
	@Autowired
	private IMagasinRepository magasinRepo;

	@GetMapping("")
	@JsonView(Views.ViewMagasin.class)
	public List<Magasin> findAll() {
		return magasinRepo.findAllWithMagasinIngredient();
	}
	
	@GetMapping("/by-ville/{ville}")
	@JsonView(Views.ViewMagasin.class)
	public List<Magasin> findAllByVille(@PathVariable String ville) {
		return magasinRepo.findAllByVille(ville);
	}
	
	@GetMapping("/by-siret/{siret}")
	@JsonView(Views.ViewMagasin.class)
	public List<Magasin> findAllBySiret(@PathVariable String siret) {
		return magasinRepo.findAllBySiret(siret);
	}
	
	@GetMapping("/by-name/{name}")
	@JsonView(Views.ViewMagasin.class)
	public List<Magasin> findAllByName(@PathVariable String name) {
		return magasinRepo.findAllByName(name);
	}
	
	@GetMapping("/by-zipCode/{zipCode}")
	@JsonView(Views.ViewMagasin.class)
	public List<Magasin> findAllByZipCode(@PathVariable String zipCode) {
		return magasinRepo.findAllByName(zipCode);
	}


	@GetMapping("/{id}")
	@JsonView(Views.ViewMagasin.class)
	public Magasin find(@PathVariable Long id) {

		Optional<Magasin> optMagasin = magasinRepo.findById(id);

		if (optMagasin.isPresent()) {
			return optMagasin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(ViewMagasinWithMagasinIngredient.class)
	public Magasin detail(@PathVariable Long id) {

		Optional<Magasin> optMagasin = magasinRepo.findByIdWithMagasinIngredient(id);

		if (optMagasin.isPresent()) {
			return optMagasin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewMagasin.class)
	public Magasin create(@Valid @RequestBody Magasin magasin, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		magasin = magasinRepo.save(magasin);

		return magasin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMagasin.class)
	public Magasin update(@RequestBody Magasin magasin, @PathVariable Long id) {
		if (!magasinRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		magasin = magasinRepo.save(magasin);

		return magasin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		magasinRepo.deleteById(id);
	}

}
