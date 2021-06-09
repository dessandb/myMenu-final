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

import sopra.myMenu.model.MagasinIngredient;
import sopra.myMenu.model.Views;
import sopra.myMenu.model.Views.ViewMagasinIngredient;
import sopra.myMenu.repository.IMagasinIngredientRepository;

@RestController
@RequestMapping("/magasinIngredient")
@CrossOrigin("*")
public class MagasinIngredientRestController {
	
	@Autowired
	private IMagasinIngredientRepository magasinIngredientRepo;

	@GetMapping("")
	@JsonView(Views.ViewMagasinIngredient.class)
	public List<MagasinIngredient> findAll() {
		return magasinIngredientRepo.findAll();
	}
	
	@GetMapping("/by-risingPrice")
	@JsonView(Views.ViewMagasinIngredient.class)
	public List<MagasinIngredient> findAllByRisingPrice() {
		return magasinIngredientRepo.findAllByRisingPrice();
	}
	
	@GetMapping("/bio")
	@JsonView(Views.ViewMagasinIngredient.class)
	public List<MagasinIngredient> findAllBio() {
		return magasinIngredientRepo.findAllBio();
	}
	
	@GetMapping("/produitLocal")
	@JsonView(Views.ViewMagasinIngredient.class)
	public List<MagasinIngredient> findAllProduitLocal() {
		return magasinIngredientRepo.findAllProduitLocal();
	}
	
	@GetMapping("/by-brand/{brand}")
	@JsonView(Views.ViewMagasinIngredient.class)
	public List<MagasinIngredient> findByBrand(@PathVariable String marque) {
		return magasinIngredientRepo.findByBrand(marque);
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMagasinIngredient.class)
	public MagasinIngredient find(@PathVariable Long id) {

		Optional<MagasinIngredient> optMagasinIngredient = magasinIngredientRepo.findById(id);

		if (optMagasinIngredient.isPresent()) {
			return optMagasinIngredient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(ViewMagasinIngredient.class)
	public MagasinIngredient detail(@PathVariable Long id) {

		Optional<MagasinIngredient> optMagasinIngredient = magasinIngredientRepo.findById(id);

		if (optMagasinIngredient.isPresent()) {
			return optMagasinIngredient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewMagasinIngredient.class)
	public MagasinIngredient create(@Valid @RequestBody MagasinIngredient magasinIngredient, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		magasinIngredient = magasinIngredientRepo.save(magasinIngredient);

		return magasinIngredient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMagasinIngredient.class)
	public MagasinIngredient update(@RequestBody MagasinIngredient magasinIngredient, @PathVariable Long id) {
		if (!magasinIngredientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		magasinIngredient = magasinIngredientRepo.save(magasinIngredient);

		return magasinIngredient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		magasinIngredientRepo.deleteById(id);
	}

}
