package sopra.myMenu.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import sopra.myMenu.model.PreferenceAlimentaire;
import sopra.myMenu.model.TypeAlimentation;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IPreferenceAlimentaireRepository;

@RestController
@RequestMapping("/preferencealimentaire")
@CrossOrigin("*")
public class PreferenceAlimentaireRestController {
	
	@Autowired
	private IPreferenceAlimentaireRepository prefAlimRepo;

	@GetMapping("")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public List<PreferenceAlimentaire> findAll() {

		return prefAlimRepo.findAll();
	}
	
	@GetMapping("/detailUtilisateur")
	@JsonView(Views.ViewPreferenceAlimentaireWithUtilisateur.class)
	public List<PreferenceAlimentaire> findAllWithUtilisateur() {

		return prefAlimRepo.findAllWithUtilisateur();
	}
	
	@GetMapping("/by-typealimentation/{typeAlimentation.label}")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public List<PreferenceAlimentaire> findAllByTypeAlimentation(@Param("typeAlimentation") TypeAlimentation typeAlimentation) {

		return prefAlimRepo.findAllByTypeAlimentation(typeAlimentation);
	}
	
	@GetMapping("/by-utilisateur/{idUtilisateur}")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public List<PreferenceAlimentaire> findAllByUtilisateur(@Param("idUtilisateur") Long idUtilisateur) {

		return prefAlimRepo.findAllByUtilisateur(idUtilisateur);
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public PreferenceAlimentaire find(@PathVariable Long id) {

		Optional<PreferenceAlimentaire> optPreferenceAlimentaire = prefAlimRepo.findById(id);

		if (optPreferenceAlimentaire.isPresent()) {
			return optPreferenceAlimentaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/detail-utilisateur")
	@JsonView(Views.ViewPreferenceAlimentaireWithUtilisateur.class)
	public PreferenceAlimentaire findByIdWithUtilisateur(@PathVariable Long id) {

		Optional<PreferenceAlimentaire> optPreferenceAlimentaire = prefAlimRepo.findByIdWithUtilisateur(id);

		if (optPreferenceAlimentaire.isPresent()) {
			return optPreferenceAlimentaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public PreferenceAlimentaire create(@Valid @RequestBody PreferenceAlimentaire preferenceAlimentaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		preferenceAlimentaire = prefAlimRepo.save(preferenceAlimentaire);

		return preferenceAlimentaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPreferenceAlimentaire.class)
	public PreferenceAlimentaire update(@RequestBody PreferenceAlimentaire preferenceAlimentaire, @PathVariable Long id) {
		if (!prefAlimRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		preferenceAlimentaire = prefAlimRepo.save(preferenceAlimentaire);

		return preferenceAlimentaire;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		prefAlimRepo.deleteById(id);
	}

}
