package spring.excercise.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.excercise.Model.Entities.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where class_id = ?1",
            nativeQuery = true)
    List<Student> getStudentsBy(int id);

}
