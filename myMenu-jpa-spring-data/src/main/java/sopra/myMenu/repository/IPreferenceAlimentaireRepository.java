package sopra.myMenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.PreferenceAlimentaire;
import sopra.myMenu.model.TypeAlimentation;

public interface IPreferenceAlimentaireRepository extends JpaRepository<PreferenceAlimentaire,Long> {

	@Query("select distinct p from PreferenceAlimentaire p where p.typeAlimentation = :typeAlimentation")
	List<PreferenceAlimentaire> findAllByTypeAlimentation(@Param("typeAlimentation") TypeAlimentation typeAlimentation);
	
	@Query("select distinct p from PreferenceAlimentaire p left join fetch p.utilisateur")
	List<PreferenceAlimentaire> findAllWithUtilisateur();
	
	@Query("select distinct p from PreferenceAlimentaire p where p.utilisateur=:idUtilisateur")
	List<PreferenceAlimentaire> findAllByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
	
	@Query("select distinct p from PreferenceAlimentaire p left join fetch p.utilisateur where p.id = :id")
	Optional<PreferenceAlimentaire> findByIdWithUtilisateur(@Param("id") Long id);
	
}
