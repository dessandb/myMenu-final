package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Planning;

	public interface IPlanningRepository extends JpaRepository<Planning, Long> {
		
		@Query("select distinct p from Planning p where p.objectif.id :=idObjectif")
		List<Planning> findAllByObjectif(@Param("idObjectif") Long idObjectif) ;
		
		@Query("select distinct p from Planning p left join fetch p.objectif where p.objectif IS NOT NULL")
		List<Planning> findAllWithObjectif() ;
		
		@Query("select  p from Planning p left join fetch p.objectif where p.objectif IS NOT NULL and p.id= :id")
		Optional<Planning> findByIdWithObjectif(@Param("id") Long id) ;
}
