package sopra.myMenu.repository;

import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.ListeCourse;

public interface IListeCourseRepository extends JpaRepository<ListeCourse,Long> {

}
