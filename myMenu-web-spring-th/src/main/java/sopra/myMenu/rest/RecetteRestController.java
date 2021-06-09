package sopra.myMenu.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.Recette;
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
}
