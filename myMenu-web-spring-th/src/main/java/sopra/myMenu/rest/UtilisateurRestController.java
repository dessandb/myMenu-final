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

import sopra.myMenu.model.Genre;
import sopra.myMenu.model.PhysicalActivity;
import sopra.myMenu.model.Utilisateur;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAll() {

		return utilisateurRepo.findAll();
	}
	
	@GetMapping("/by-email/{email}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByEmail(@PathVariable String email) {

		return utilisateurRepo.findAllByEmail(email);
	}
	
	@GetMapping("/by-telephone/{telephone}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByTelephone(@PathVariable String telephone) {

		return utilisateurRepo.findAllByTelephone(telephone);
	}
	
	@GetMapping("/by-imc/{imc}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByImc(@PathVariable Float imc) {

		return utilisateurRepo.findAllByImc(imc);
	}
	
	@GetMapping("/by-physical-activity/{physicalActivity.label}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByPhysicalActivity(@PathVariable PhysicalActivity physicalActivity) {

		return utilisateurRepo.findAllByPhysicalActivity(physicalActivity);
	}
	
	@GetMapping("/by-genre/{genre.label}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByGenre(@PathVariable Genre genre) {

		return utilisateurRepo.findAllByGenre(genre);
	}
	
	@GetMapping("/by-nom-prenom/{nom}:{prenom}")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAllByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom) {

		return utilisateurRepo.findAllByNomAndPrenom(nom,prenom);
	}
	
	@GetMapping("/{id}")
	public Utilisateur find(@PathVariable Long id) {

		Optional<Utilisateur> optUtilisateur = utilisateurRepo.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		utilisateurRepo.deleteById(id);
	}
	
}
