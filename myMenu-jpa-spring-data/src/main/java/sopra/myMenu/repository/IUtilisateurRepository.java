package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenu.model.Genre;
import sopra.myMenu.model.PhysicalActivity;
import sopra.myMenu.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long> {
	
	@Query("select distinct u from Utilisateur u where u.email = :email")
	List<Utilisateur> findAllByEmail(@Param("email") String email);
	
	@Query("select distinct u from Utilisateur u where u.telephone = :telephone")
	List<Utilisateur> findAllByTelephone(@Param("telephone") String telephone);
	
	@Query("select distinct u from Utilisateur u where u.imc = :imc")
	List<Utilisateur> findAllByImc(@Param("imc") Float imc);
	
	@Query("select distinct u from Utilisateur u where u.physicalActivity = :physicalActivity")
	List<Utilisateur> findAllByPhysicalActivity(@Param("physicalActivity") PhysicalActivity physicalActivity);
	
	@Query("select distinct u from Utilisateur u where u.genre = :genre")
	List<Utilisateur> findAllByGenre(@Param("genre") Genre genre);
	
	@Query("select distinct u from Utilisateur u where u.nom = :nom and u.prenom = :prenom")
	List<Utilisateur> findAllByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);
	
}
