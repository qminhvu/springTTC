package spring.excercise.Service.Mapper;

import spring.excercise.Model.DTO.ClassDTO;
import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;

public class ClassMapper {
    public ClassMapper() {

    }
    public void setNameMapper(Class aClass, ClassDTO classDTO) {
        aClass.setName(classDTO.getName());
    }

    public void setAll(Class aClass, ClassDTO classDTO) {
        setNameMapper(aClass, classDTO);
    }

}
