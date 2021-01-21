package spring.excercise.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.excercise.Model.DTO.StudentCreate;

import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Payroll.ClassNotFound;
import spring.excercise.Payroll.StudentNotFound;
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
                .orElseThrow(() -> new StudentNotFound(id));
    }

    public Student create(StudentCreate studentCreate) throws Exception {
        Student student = new Student();
        Class aClass = classRepo.findById(studentCreate.getaClass().getId()).orElseThrow(() -> new ClassNotFound(studentCreate.getaClass().getId()));
        student.setName(studentCreate.getName());
        student.setBirthday(studentCreate.getBirthday());
        student.setAddress(studentCreate.getAddress());
        student.setPhoneNumber(studentCreate.getPhoneNumber());
        student.setaClass(aClass);
        return studentRepo.save(student);
    }

    public Student replaceStudent(Student newStudent, int id) {
        Class aClass = classRepo.findById(newStudent.getaClass().getId()).orElseThrow(() -> new ClassNotFound(newStudent.getaClass().getId()));
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setAddress(newStudent.getAddress());
                    student.setBirthday(newStudent.getBirthday());
                    student.setPhoneNumber(newStudent.getPhoneNumber());
                    student.setaClass(aClass);
                    return studentRepo.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepo.save(newStudent);
                });
    }

    public String delete(int id) {
        Student student = studentRepo.findById(id).orElse(null);
        if(student == null) return "Fail";
        studentRepo.delete(student);
        return "Success";
    }


}
