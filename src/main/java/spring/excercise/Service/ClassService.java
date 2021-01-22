package spring.excercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.excercise.Exceptions.ClassExistedException;
import spring.excercise.Exceptions.NotNullException;
import spring.excercise.Exceptions.StudentNotFoundException;
import spring.excercise.Model.DTO.ClassDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Service.IService.IClassService;
import spring.excercise.Service.Mapper.ClassMapper;
import spring.excercise.Repositories.ClassRepo;
import spring.excercise.Repositories.StudentRepo;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Class> read() {
        return classRepo.findAll();
    }

    @Override
    public Class readByID(int id) {
        return classRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> getStudents(int id) {
        return studentRepo.getStudentsBy(id);
    }

    @Override
    public Class create(ClassDTO classDTO) {
        ClassMapper classMapper = new ClassMapper();
        List<Class> classes = classRepo.findAll();
        Class classEntity = new Class();
        for(Class aClass : classes){
            if(aClass.getName().equals(classDTO.getName())){
                throw new ClassExistedException();
            }
        }
        classMapper.setAll(classEntity, classDTO);
        if(classEntity.getName().equals("")){
            throw new NotNullException();
        }
        return classRepo.save(classEntity);
    }

    @Override
    public Class replaceClass(Class newClass, int id) {
        List<Class> classes = classRepo.findAll();
        return classRepo.findById(id)
                .map(classEntity -> {
                    for(Class aClass : classes){
                        if(aClass.getName().equals(newClass.getName())){
                            throw new ClassExistedException();
                        }
                    }
                    classEntity.setName(newClass.getName());
                    if(classEntity.getName().equals("")){
                        throw new NotNullException();
                    }
                    return classRepo.save(classEntity);
                })
                .orElseGet(() -> {
                    newClass.setId(id);
                    return classRepo.save(newClass);
                });
    }

    @Override
    public void delete(int id) {
        classRepo.deleteById(id);
    }
}
