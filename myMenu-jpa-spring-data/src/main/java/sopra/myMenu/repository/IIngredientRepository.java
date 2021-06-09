package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

	@Query("select i from Ingredient i where i.nom= :nom")
	List<Ingredient> findByName(@Param("nom") String nom);
	
//	@Query("select i from Ingredient i where i.produit_saison= :produit_saison")
//	List<Ingredient> findByProduitSaison(@Param("produit_saison") String produit_saison);
	
//	@Query("select i from Ingredient i where i.type_produit= :type_produit")
//	List<Ingredient> findByTypeProduit(@Param("type_produit") String type_produit);
	
}
