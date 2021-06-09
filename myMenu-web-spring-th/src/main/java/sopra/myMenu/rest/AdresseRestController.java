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

import sopra.myMenu.model.Adresse;
import sopra.myMenu.model.Coordonnees;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IAdresseRepository;

@RestController
@RequestMapping("/adresse")
@CrossOrigin("*")
public class AdresseRestController {
	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping("")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAll() {

		return adresseRepo.findAll();
	}
	
	@GetMapping("/by-magasin/{idMagasin}")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllByMagasin(@PathVariable Long idMagasin) {

		return adresseRepo.findAllByMagasin(idMagasin);
	}
	
	@GetMapping("/with-magasin")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllWithMagasin() {

		return adresseRepo.findAllWithMagasin();
	}
	
	@GetMapping("/{id}/detail-magasin")
	@JsonView(Views.ViewAdresse.class)
	public Adresse detailMagasin(@Param("id") Long id) {

		Optional<Adresse> optAdresse= adresseRepo.findByIdWithMagasin(id);
		
		if (optAdresse.isPresent()) {
			return optAdresse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
	}
	
	
	
	@GetMapping("/by-utilisateur/{idUtilisateur}")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllByUtilisateur(@PathVariable Long idUtilisateur) {

		return adresseRepo.findAllByUtilisateur(idUtilisateur);
	}
	
	@GetMapping("/with-utilisateur")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllWithUtilisateur() {

		return adresseRepo.findAllWithUtilisateur();
	}
	
	@GetMapping("/{id}/detail-utilisateur")
	@JsonView(Views.ViewAdresse.class)
	public Adresse detailUtilisateur(@Param("id") Long id) {

		Optional<Adresse> optAdresse= adresseRepo.findByIdWithUtilisateur(id);
		
		if (optAdresse.isPresent()) {
			return optAdresse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
	}

	@GetMapping("/{id}")
	public Adresse find(@PathVariable Long id) {

		Optional<Adresse> optAdresse = adresseRepo.findById(id);

		if (optAdresse.isPresent()) {
			return optAdresse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-coordonnees/{coordonnees.latitude}:{coordonnees.longitude}")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllByCoordonnees(@PathVariable Coordonnees coordonnees) {

		return adresseRepo.findAllByCoordonnees(coordonnees);
	}
	
	@GetMapping("/by-ville/{ville}")
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> findAllByVille(@PathVariable String ville) {

		return adresseRepo.findAllByVille(ville);
	}

	@PostMapping("")
	public Adresse create(@Valid @RequestBody Adresse adresse, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		adresse = adresseRepo.save(adresse);

		return adresse;
	}

	@PutMapping("/{id}")
	public Adresse update(@RequestBody Adresse adresse, @PathVariable Long id) {
		if (!adresseRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		adresse = adresseRepo.save(adresse);

		return adresse;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		adresseRepo.deleteById(id);
	}
	
	
}
