package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Magasin;

public interface IMagasinRepository extends JpaRepository<Magasin, Long> {
	@Query("select e from Magasin e where e.nom= :nom ")
	List<Magasin> findAllByName(@Param("nom") String nom);
	
	@Query("select e from Magasin e where e.siret= :siret ")
	List<Magasin> findAllBySiret(@Param("siret") String siret);
	
	@Query("select a.magasin from Adresse a where a.ville= :ville ")
	List<Magasin> findAllByVille(@Param("ville") String ville);
	
	@Query("select a.magasin from Adresse a where a.codePostal= :codePostal ")
	List<Magasin> findAllByZipCode(@Param("codePostal") String codePostal);
	
	@Query("select distinct m from Magasin m left join fetch m.magasinIngredient where m.id = :id")
	Optional<Magasin> findByIdWithMagasinIngredient(@Param("id") Long id);

	@Query("select distinct m from Magasin m left join fetch m.magasinIngredient")
	List<Magasin> findAllWithMagasinIngredient();
	
}
