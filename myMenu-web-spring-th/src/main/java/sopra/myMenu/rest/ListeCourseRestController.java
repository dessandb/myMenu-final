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

import sopra.myMenu.model.ListeCourse;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IListeCourseRepository;


@RestController
@RequestMapping("/listeCourse")
@CrossOrigin("*")
public class ListeCourseRestController {

	@Autowired
	private IListeCourseRepository listeCourseRepo;

	@GetMapping("")
	@JsonView(Views.ViewListeCourse.class)
	public List<ListeCourse> findAllWithAjustement() {
		return listeCourseRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewListeCourse.class)
	public ListeCourse find(@PathVariable Long id) {

		Optional<ListeCourse> optListeCourse = listeCourseRepo.findById(id);

		if (optListeCourse.isPresent()) {
			return optListeCourse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewListeCourseWithAjustement.class)
	public ListeCourse detail(@PathVariable Long id) {

		Optional<ListeCourse> optListeCourse = listeCourseRepo.findByIdWithAjustement(id);

		if (optListeCourse.isPresent()) {
			return optListeCourse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	@PostMapping("")
	@JsonView(Views.ViewListeCourse.class)
	public ListeCourse create(@Valid @RequestBody ListeCourse listeCourse, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		listeCourse = listeCourseRepo.save(listeCourse);

		return listeCourse;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewListeCourse.class)
	public ListeCourse update(@RequestBody ListeCourse listeCourse, @PathVariable Long id) {
		if (!listeCourseRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		listeCourse = listeCourseRepo.save(listeCourse);

		return listeCourse;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		listeCourseRepo.deleteById(id);
	}
	
}
