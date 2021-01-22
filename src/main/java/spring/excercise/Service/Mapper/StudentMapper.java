package spring.excercise.Service.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.excercise.Exceptions.ClassNotFoundException;
import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.repositories.ClassRepo;
import spring.excercise.repositories.StudentRepo;

import java.time.LocalDate;

public class StudentMapper {

    @Autowired
    private ClassRepo classRepo;

    public StudentMapper() {

    }

    public void setNameMapper(Student student, StudentDTO studentDTO) {
        student.setName(studentDTO.getName());
    }

    public void setBirthdayMapper(Student student, StudentDTO studentDTO) {
        student.setBirthday(studentDTO.getBirthday());
    }

    public void setAddressMapper(Student student, StudentDTO studentDTO) {
        student.setAddress(studentDTO.getAddress());
    }

    public void setPhoneNumberMapper(Student student, StudentDTO studentDTO) {
        student.setPhoneNumber(studentDTO.getPhoneNumber());
    }

    public void setClass(Student student, StudentDTO studentDTO) {
        Class aClass = classRepo.findById(studentDTO.getaClass().getId())
                .orElseThrow(() -> new ClassNotFoundException(studentDTO.getaClass().getId()));
        student.setaClass(aClass);
    }

    public void setAll(Student student, StudentDTO studentDTO) {
        setNameMapper(student, studentDTO);
        setBirthdayMapper(student, studentDTO);
        setAddressMapper(student, studentDTO);
        setPhoneNumberMapper(student, studentDTO);
        setClass(student, studentDTO);
    }
}
