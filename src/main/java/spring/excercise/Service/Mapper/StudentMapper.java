package spring.excercise.Service.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import spring.excercise.Exceptions.ClassNotFoundException;
import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Repositories.ClassRepo;

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

    public void setAll(Student student, StudentDTO studentDTO) {
        setNameMapper(student, studentDTO);
        setBirthdayMapper(student, studentDTO);
        setAddressMapper(student, studentDTO);
        setPhoneNumberMapper(student, studentDTO);
    }
}
