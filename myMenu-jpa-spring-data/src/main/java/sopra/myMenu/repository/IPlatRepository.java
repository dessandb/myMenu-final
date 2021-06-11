package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Plat;

public interface IPlatRepository extends JpaRepository <Plat,Long>{

	@Query("select distinct p from Plat p where p.repas= :repas")
	List<Plat>findAllByRepas(@Param("repas")String repas);
	
	@Query("select distinct p from Plat p left join fetch p.repas")
	List<Plat>findAllWithRepas(@Param("repas")String repas);
	
}


