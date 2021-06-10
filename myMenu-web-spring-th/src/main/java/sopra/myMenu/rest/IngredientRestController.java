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


import sopra.myMenu.model.Ingredient;

import sopra.myMenu.model.ProduitSaison;
import sopra.myMenu.model.TypeProduit;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IIngredientRepository;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin("*")
public class IngredientRestController {

	@Autowired
	private IIngredientRepository ingredientRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewIngredient.class)
	public List<Ingredient>  findAll(){
		List<Ingredient> ingredients = ingredientRepo.findAll();
		
		return ingredients;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewIngredient.class)
	
	public Ingredient find(@PathVariable Long id) {
		
		Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
		
		if(optIngredient.isPresent()) {
			return optIngredient.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		}
		
	@GetMapping("/by-produitSaison/{produitSaison}")
	@JsonView(Views.ViewIngredient.class)
	public List<Ingredient> findIngredientByProduitSaison(@PathVariable ProduitSaison produitSaison) {
			
		return ingredientRepo.findIngredientByProduitSaison(produitSaison);

	}
	@GetMapping("/by-typeProduit/{typeProduit}")
	@JsonView(Views.ViewIngredient.class)
	public List<Ingredient> findIngredientByTypeProduit(@PathVariable TypeProduit typeProduit) {
			
		return ingredientRepo.findIngredientByTypeProduit(typeProduit);
	}
	@GetMapping("/by-name/{name}")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient findIngredientByName(@PathVariable String name) {
			
		return ingredientRepo.findIngredientByName(name);
	}
	@PostMapping("")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		ingredient = ingredientRepo.save(ingredient);

		return ingredient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable Long id) {
		if (!ingredientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		ingredient = ingredientRepo.save(ingredient);

		return ingredient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		ingredientRepo.deleteById(id);
	}
}

	
	
	
	
	
	

