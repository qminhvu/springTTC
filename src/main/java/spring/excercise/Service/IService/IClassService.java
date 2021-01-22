package spring.excercise.Service.IService;

import spring.excercise.Model.DTO.ClassDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;

import java.util.List;

public interface IClassService {
    public List<Class> read();
    public Class readByID(int id);
    public List<Student> getStudents(int id);
    public Class create(ClassDTO classDTO);
    public Class replaceClass(Class newClass, int id);
    public void delete(int id);
}
