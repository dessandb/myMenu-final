package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Magasin;

public interface IMagasinRepository extends JpaRepository<Magasin, Long> {
	@Query("select e from Magasin e where e.nom= :nom ")
	List<Magasin> findByName(@Param("nom") String nom);
	
	@Query("select e from Magasin e where e.siret= :siret ")
	List<Magasin> findBySiret(@Param("siret") String siret);
	
	@Query("select a.magasin from Adresse a where a.ville= :ville ")
	List<Magasin> findByVille(@Param("ville") String ville);
	
	@Query("select a.magasin from Adresse a where a.codePostal= :codePostal ")
	List<Magasin> findByZipCode(@Param("codePostal") String codePostal);
	
}
