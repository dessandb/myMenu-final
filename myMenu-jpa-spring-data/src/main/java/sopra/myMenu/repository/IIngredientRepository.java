package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.ProduitSaison;
import sopra.myMenu.model.TypeProduit;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

	@Query("select i from Ingredient i where i.nom= :nom")
	Ingredient findIngredientByName(@Param("nom") String nom);
	
	@Query("select i from Ingredient i where i.produitSaison= :produitSaison")
	List<Ingredient> findIngredientByProduitSaison(@Param("produitSaison") ProduitSaison produitSaison);
	
	@Query("select i from Ingredient i where i.typeProduit= :typeProduit")
	List<Ingredient> findIngredientByTypeProduit(@Param("typeProduit") TypeProduit typeProduit);

	
	
}
