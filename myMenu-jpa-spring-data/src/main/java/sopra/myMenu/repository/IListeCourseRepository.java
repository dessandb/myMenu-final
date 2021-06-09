package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.ListeCourse;

public interface IListeCourseRepository extends JpaRepository<ListeCourse,Long> {
	
	@Query("select distinct l from ListeCourse l left join fetch l.ajustementQuantite")
	List<ListeCourse> findAllWithAjustement();

	@Query("select distinct l from ListeCourse l left join fetch l.ajustementQuantite where l.id = :id")
	Optional<ListeCourse> findByIdWithAjustement(@Param("id") Long id);
	
}
