package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopra.myMenu.model.Recette;
import sopra.myMenu.model.TypeAlimentation;


public interface IRecetteRepository extends JpaRepository<Recette, Long>{
	
	@Query("select r from Recette r where r.nom= :nom")
	List<Recette> findByName(@Param("nom") String nom);
	
	@Query("select r from Recette r ORDER BY r.totalCalories ASC")
	List<Recette> findByRisingCalories();
	
	@Query("select r from Recette r where r.note= :note")
	List<Recette> findByNote(@Param("note") float note);

	@Query("select r from Recette r ORDER BY r.note ASC")
	List<Recette> findByRisingNote();

	@Query("select t from Recette r where r.typeAlimentation= :typeAlimentation")
	List<Recette> findByTypeAlimentation(@Param("typeAlimentation")TypeAlimentation typeAlimentation);
	
//	@Query("select t from Recette r where r.typeAlimentation= :typeAlimentation")
//	List<Recette> findByTypeAlimentation(@Param("typeAlimentation") TypeAlimentation typeAlimentation);
}
