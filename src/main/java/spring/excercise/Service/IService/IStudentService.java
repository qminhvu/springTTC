package spring.excercise.Service.IService;

import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> read();
    public Student readByID(int id);
    public Student create(StudentDTO studentDTO);
    public Student replaceStudent(Student newStudent, int id);
    public void delete(int id);
}
