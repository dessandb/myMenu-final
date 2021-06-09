package sopra.myMenu.rest;

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

import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.Recette;
import sopra.myMenu.model.TypeAlimentation;
import sopra.myMenu.model.TypeProduit;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IRecetteRepository;

@RestController
@RequestMapping("/recette")
@CrossOrigin("*")
public class RecetteRestController {

	@Autowired
	private IRecetteRepository recetteRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewRecette.class)
	public List<Recette>  findAll(){
		List<Recette> recettes = recetteRepo.findAll();
		
		return recettes;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewRecette.class)
	
	public Recette find(@PathVariable Long id) {
		
		Optional<Recette> optRecette = recetteRepo.findById(id);
		
		if(optRecette.isPresent()) {
			return optRecette.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		}
	@GetMapping("/by-name/{name}")
	@JsonView(Views.ViewRecette.class)
	public Recette findRecetteByName(@PathVariable String name) {
			
		return recetteRepo.findRecetteByName(name);
	}
	
	@GetMapping("/by-typeAlimentation/{typeAlimentation}")
	@JsonView(Views.ViewIngredient.class)
	public List<Recette> findRecetteByTypeAlimentation(@PathVariable TypeAlimentation typeAlimentation) {
			
		return recetteRepo.findRecetteByTypeAlimentation(typeAlimentation);
	}
//	@GetMapping("")
//	@JsonView(Views.ViewIngredient.class)
//	public List<Recette> findRecetteByRisingCalories(@PathVariable int totalCalories) {
//		
//		return recetteRepo.findRecetteByRisingCalories();
//
//	}
	
	@GetMapping("/by-note/{note}")
	@JsonView(Views.ViewIngredient.class)
	public List<Recette> findRecetteByRisingNote(@PathVariable int note) {
		
		return recetteRepo.findRecetteByRisingNote();

	
}
	@PostMapping("")
	@JsonView(Views.ViewRecette.class)
	public Recette create(@RequestBody Recette recette) {
		recette = recetteRepo.save(recette);

		return recette;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewRecette.class)
	public Recette update(@RequestBody Recette recette, @PathVariable Long id) {
		if (!recetteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		recette = recetteRepo.save(recette);

		return recette;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		recetteRepo.deleteById(id);
	}
}

	
	
	
	
	
	

