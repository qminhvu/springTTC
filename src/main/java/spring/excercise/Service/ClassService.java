package spring.excercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.excercise.Model.DTO.ClassCreate;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Payroll.ClassExisted;
import spring.excercise.repositories.ClassRepo;
import spring.excercise.repositories.StudentRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private StudentRepo studentRepo;

    public List<Class> read() {
        return classRepo.findAll();
    }

    public List<? extends Object> readByID(int id) {
        List<Student> students = studentRepo.getStudentsBy(id);
        if(students.isEmpty())
        {
            return classRepo.findById(id).stream().collect(Collectors.toList());
        }
        return studentRepo.getStudentsBy(id);
    }

    public Class create(ClassCreate classCreate) throws Exception {
        List<Class> classes = classRepo.findAll();
        Class classEntity = new Class();
        for(Class aClass : classes){
            if(aClass.getName().equals(classCreate.getName())){
                throw new ClassExisted();
            }
        }
        classEntity.setName(classCreate.getName());
        classEntity = classRepo.save(classEntity);
        return classEntity;
    }

    public Class replaceClass(Class newClass, int id) {
        List<Class> classes = classRepo.findAll();
        return classRepo.findById(id)
                .map(classEntity -> {
                    for(Class aClass : classes){
                        if(aClass.getName().equals(newClass.getName())){
                            throw new ClassExisted();
                        }
                    }
                    classEntity.setName(newClass.getName());
                    return classRepo.save(classEntity);
                })
                .orElseGet(() -> {
                    newClass.setId(id);
                    return classRepo.save(newClass);
                });
    }

    public String delete(int id) {
        Class classEntity = classRepo.findById(id).orElse(null);
        if(classEntity == null) return "Fail";
        classRepo.delete(classEntity);
        return "Success";
    }
}
