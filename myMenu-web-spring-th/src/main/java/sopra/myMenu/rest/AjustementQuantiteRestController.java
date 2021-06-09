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

import sopra.myMenu.model.AjustementQuantite;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IAjustementQuantiteRepository;

@RestController
@RequestMapping("/ajustementQuantite")
@CrossOrigin("*")
public class AjustementQuantiteRestController {
	@Autowired
	private IAjustementQuantiteRepository ajustementRepo;

	@GetMapping("")
	@JsonView(Views.ViewAjustementQuantite.class)
	public List<AjustementQuantite> findAll() {
		return ajustementRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAjustementQuantite.class)
	public AjustementQuantite find(@PathVariable Long id) {

		Optional<AjustementQuantite> optAjustementQuantite = ajustementRepo.findById(id);

		if (optAjustementQuantite.isPresent()) {
			return optAjustementQuantite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewAjustementQuantite.class)
	public AjustementQuantite create(@RequestBody AjustementQuantite ajustement) {
		ajustement = ajustementRepo.save(ajustement);

		return ajustement;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAjustementQuantite.class)
	public AjustementQuantite update(@RequestBody AjustementQuantite ajustement, @PathVariable Long id) {
		if (!ajustementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		ajustement = ajustementRepo.save(ajustement);

		return ajustement;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		ajustementRepo.deleteById(id);
	}
}
