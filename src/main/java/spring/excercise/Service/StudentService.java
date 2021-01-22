package spring.excercise.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.excercise.Exceptions.ClassNotFoundException;
import spring.excercise.Exceptions.NotNullException;
import spring.excercise.Exceptions.StudentNotFoundException;
import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.repositories.ClassRepo;
import spring.excercise.repositories.StudentRepo;


import java.util.List;



@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ClassRepo classRepo;

    public List<Student> read() {
        return studentRepo.findAll();
    }

    public Student readByID(int id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(StudentDTO studentDTO) {
        Student student = new Student();
        Class aClass = classRepo.findById(studentDTO.getaClass().getId())
                .orElseThrow(() -> new ClassNotFoundException(studentDTO.getaClass().getId()));
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setBirthday(studentDTO.getBirthday());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setaClass(aClass);
        if(student.getName().equals("")
        || student.getAddress().equals("")
        || student.getPhoneNumber().equals("")){
            throw new NotNullException();
        }
        return studentRepo.save(student);
    }

    public Student replaceStudent(Student newStudent, int id) {
        Class aClass = classRepo.findById(newStudent.getaClass().getId())
                        .orElseThrow(() -> new ClassNotFoundException(newStudent.getaClass().getId()));
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setAddress(newStudent.getAddress());
                    student.setBirthday(newStudent.getBirthday());
                    student.setPhoneNumber(newStudent.getPhoneNumber());
                    student.setaClass(aClass);
                    if(student.getName().equals("")
                            || student.getAddress().equals("")
                            || student.getPhoneNumber().equals("")){
                        throw new NotNullException();
                    }
                    return studentRepo.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepo.save(newStudent);
                });
    }

    public void delete(int id) {
        studentRepo.deleteById(id);
    }


}
