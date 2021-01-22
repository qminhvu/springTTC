package spring.excercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.excercise.Model.DTO.ClassDTO;
import spring.excercise.Model.Entities.Class;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Service.ClassService;


import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService service;

    @GetMapping
    public List<Class> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public Class readOne(@PathVariable("id") int id) {
        return service.readByID(id);
    }

    @GetMapping("/{id}/students")
    public List<Student> readStudentList(@PathVariable("id") int id) {
        return service.getStudents(id);
    }

    @PutMapping("/{id}")
    public Class replaceClass(@RequestBody Class classEntity, @PathVariable int id) {
        return service.replaceClass(classEntity, id);
    }

    @PostMapping
    public Class create(@RequestBody ClassDTO classDTO) {
        return service.create(classDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
