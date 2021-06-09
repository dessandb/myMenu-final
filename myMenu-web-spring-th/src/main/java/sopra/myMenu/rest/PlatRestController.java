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

import sopra.myMenu.model.Plat;
import sopra.myMenu.model.ProduitSaison;
import sopra.myMenu.model.TypeProduit;
import sopra.myMenu.model.Views;
import sopra.myMenu.repository.IPlatRepository;
@RestController
	@RequestMapping("/plat")
	@CrossOrigin("*")
public class PlatRestController {
	

		@Autowired
		private IPlatRepository platRepo;
		
		@GetMapping("")
		@JsonView(Views.ViewPlat.class)
		public List<Plat>  findAll(){
			List<Plat> plats = platRepo.findAll();
			
			return plats;
		}
		@GetMapping("/by-repas/{repas}")
		@JsonView(Views.ViewPlat.class)
		public List<Plat> findAllByRepas(@PathVariable String repas) {
				
			return platRepo.findAllByRepas(repas);

		}
		@GetMapping("/{id}")
		@JsonView(Views.ViewPlat.class)
		
		public Plat find(@PathVariable Long id) {
			
			Optional<Plat> optPlat = platRepo.findById(id);
			
			if(optPlat.isPresent()) {
				return optPlat.get();
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}
			}
			
		
		@GetMapping("/detailrepas")
		@JsonView(Views.ViewPlat.class)
		public List<Plat> findAllWithRepas(@PathVariable String repas) {
				
			return platRepo.findAllWithRepas(repas);
		}
		
		@PostMapping("")
		@JsonView(Views.ViewPlat.class)
		public Plat create(@RequestBody Plat plat) {
			plat = platRepo.save(plat);

			return plat;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewPlat.class)
		public Plat update(@RequestBody Plat plat, @PathVariable Long id) {
			if (!platRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}

			plat = platRepo.save(plat);

			return plat;
		}

		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			platRepo.deleteById(id);
		}
	}

		
		
		
		
		
		


