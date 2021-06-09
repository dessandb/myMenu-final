package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Menu;

public interface IMenuRepository extends JpaRepository<Menu, Long>{

}
