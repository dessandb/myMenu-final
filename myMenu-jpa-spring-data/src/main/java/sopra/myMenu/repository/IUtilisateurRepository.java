package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Adresse;
import sopra.myMenu.model.Coordonnees;
import sopra.myMenu.model.Magasin;
import sopra.myMenu.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long> {
	
	@Query("select a from Adresse a where a.magasin.id = :idMagasin")
	List<Adresse> findAllbyMagasin(@Param("idMagasin") Magasin magasin);
	
	@Query("select  a from Adresse a where a.utilisateur.id = :idUtilisateur")
	List<Adresse> findAllbyUtilisateur(@Param("idUtilisateur") Utilisateur utilisateur);
	
	@Query("select distinct a from Adresse a where a.coordonnees = :coordonnees")
	Optional<Adresse> findAllByCoordonnees(@Param("coordonnees") Coordonnees coordonnees);
	
	@Query("select distinct a from Adresse a where a.ville = :ville")
	Optional<Adresse> findAllByVille(@Param("ville") String ville);
	

}
