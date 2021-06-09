package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.PreferenceAlimentaire;

public interface IPreferenceAlimentaireRepository extends JpaRepository<PreferenceAlimentaire,Long> {

}
