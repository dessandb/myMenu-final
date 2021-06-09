package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
