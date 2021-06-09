package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Planning;

	public interface IPlanningRepository extends JpaRepository<Planning, Long> {
}
