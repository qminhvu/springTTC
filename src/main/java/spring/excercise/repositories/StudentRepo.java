package spring.excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.excercise.Model.Entities.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
