package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Planning;

	public interface IPlanningRepository extends JpaRepository<Planning, Long> {
		
		@Query("select distinct p from Planning p WHERE p.objectif.id =:idObjectif")
		List<Planning> findAllByObjectif(@Param("idObjectif") Long idObjectif);
		
		@Query("select distinct p from Planning p left join fetch p.objectif WHERE p.objectif IS NOT  NULL")
		List<Planning> findAllWithObjectif();
		
		@Query("select distinct p from Planning p left join fetch p.objectif where p.id = :id")
		Optional<Planning> findByIdWithObjectif(@Param("id") Long id);
		
		@Query("select distinct p from Planning p WHERE p.utilisateur.id =:idUtilisateur")
		List<Planning> findAllByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
		
		@Query("select distinct p from Planning p left join fetch p.utilisateur WHERE p.utilisateur IS NOT  NULL")
		List<Planning> findAllWithUtilisateur();
		
		@Query("select distinct p from Planning p left join fetch p.utilisateur where p.id = :id")
		Optional<Planning> findByIdWithUtilisateur(@Param("id") Long id);
}
