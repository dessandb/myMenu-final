package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Adresse;
import sopra.myMenu.model.Coordonnees;

public interface IAdresseRepository extends JpaRepository<Adresse,Long> {
	@Query("select a from Adresse a where a.magasin.id = :idMagasin")
	List<Adresse> findAllByMagasin(@Param("idMagasin") Long idMagasin);
	
	@Query("select a from Adresse a left join fetch a.magasin where a.magasin IS NOT NULL")
	List<Adresse> findAllWithMagasin();
	
	@Query("select a from Adresse a left join fetch a.magasin where a.id = :id")
	Optional<Adresse> findByIdWithMagasin(@Param("id") Long id);
	
	@Query("select  a from Adresse a where a.utilisateur.id = :idUtilisateur")
	List<Adresse> findAllByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
	
	@Query("select  a from Adresse a left join fetch a.utilisateur where a.utilisateur IS NOT NULL")
	List<Adresse> findAllWithUtilisateur();
	
	@Query("select  a from Adresse a left join fetch a.utilisateur where a.id = :id")
	Optional<Adresse> findByIdWithUtilisateur(@Param("id") Long id);
	
	@Query("select distinct a from Adresse a where a.coordonnees = :coordonnees")
	List<Adresse> findAllByCoordonnees(@Param("coordonnees") Coordonnees coordonnees);
	
	@Query("select distinct a from Adresse a where a.ville = :ville")
	List<Adresse> findAllByVille(@Param("ville") String ville);
	
}
