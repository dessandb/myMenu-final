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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.myMenu.model.Planning;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IPlanningRepository;

@RestController
@RequestMapping("/planning")
@CrossOrigin("*")
public class PlanningRestController {

	@Autowired
	private IPlanningRepository planningRepo;

	@GetMapping("")
	@JsonView(Views.ViewPlanning.class)
	public List<Planning> findAll() {
		return planningRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewPlanning.class)
	public Planning find(@PathVariable Long id) {

		Optional<Planning> optPlanning = planningRepo.findById(id);

		if (optPlanning.isPresent()) {
			return optPlanning.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/detail-objectif")
	@JsonView(Views.ViewPlanningWithObjectif.class)
	public Planning findByIdWithObjectif(@PathVariable Long id) {

		Optional<Planning> optPlanning = planningRepo.findByIdWithObjectif(id);

		if (optPlanning.isPresent()) {
			return optPlanning.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-objectif/{idObjectif}")
	@JsonView(Views.ViewPlanning.class)
	public List<Planning> findAllByObjectif(@PathVariable Long idObjectif) {

		List<Planning> plannings = planningRepo.findAllByObjectif(idObjectif);

		return plannings;
	}
	
	@GetMapping("/{id}/detail-utilisateur")
	@JsonView(Views.ViewPlanningWithUtilisateur.class)
	public Planning findByIdWithUtilisateur(@PathVariable Long id) {

		Optional<Planning> optPlanning = planningRepo.findByIdWithUtilisateur(id);

		if (optPlanning.isPresent()) {
			return optPlanning.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-utilisateur/{idUtilisateur}")
	@JsonView(Views.ViewPlanning.class)
	public List<Planning> findAllByUtilisateur(@PathVariable Long idUtilisateur) {

		List<Planning> plannings = planningRepo.findAllByUtilisateur(idUtilisateur);

		return plannings;
	}
	
	@GetMapping("/with-utilisateur")
	@JsonView(Views.ViewPlanningWithUtilisateur.class)
	public List<Planning> findAllWithUtilisateur() {

		List<Planning> plannings = planningRepo.findAllWithUtilisateur();

		return plannings;
	}
		
	@GetMapping("/with-objectif")
	@JsonView(Views.ViewPlanningWithObjectif.class)
	public List<Planning> findAllWithObjectif() {

		List<Planning> plannings = planningRepo.findAllWithObjectif();

		return plannings;
	}
	
	@PostMapping("")
	@JsonView(Views.ViewListeCourse.class)
	public Planning create(@Valid @RequestBody Planning planning, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		planning = planningRepo.save(planning);

		return planning;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		planningRepo.deleteById(id);
	}
	
}
