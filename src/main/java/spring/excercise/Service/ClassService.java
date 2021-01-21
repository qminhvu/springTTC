package spring.excercise.Service;

import Payroll.StudentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.excercise.Model.DTO.ClassCreate;
import spring.excercise.Model.Entities.Class;
import spring.excercise.repositories.ClassRepo;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepo;

    public List<Class> read() {
        return classRepo.findAll();
    }

    public Class readByID(int id) {
        return classRepo.findById(id)
                .orElseThrow(() -> new StudentNotFound(id));
    }

    public Class create(ClassCreate classCreate) {
        Class classEntity = new Class();
        classEntity.setName(classCreate.getName());
        classEntity = classRepo.save(classEntity);
        return classEntity;
    }

    public Class replaceClass(Class newClass, int id) {
        return classRepo.findById(id)
                .map(classEntity -> {
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
