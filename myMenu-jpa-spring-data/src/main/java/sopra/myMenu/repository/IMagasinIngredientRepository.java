package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.MagasinIngredient;

public interface IMagasinIngredientRepository extends JpaRepository<MagasinIngredient, Long>{

	@Query("select e from MagasinIngredient e ORDER BY e.prix ASC")
	List<MagasinIngredient> findAllByRisingPrice();
	
	@Query("select e from MagasinIngredient e where e.bio=true")
	List<MagasinIngredient> findAllBio();
	
	@Query("select e from MagasinIngredient e where e.produitLocal=true ")
	List<MagasinIngredient> findAllProduitLocal();
	
	@Query("select e from MagasinIngredient e where e.marque= :marque ")
	List<MagasinIngredient> findByBrand(@Param("marque") String marque);
	
	@Query("select m.magasinIngredient from Magasin m where m.nom= :magasin")
	List<MagasinIngredient> findByMagasin(@Param("magasin") String magasin);
	

}
