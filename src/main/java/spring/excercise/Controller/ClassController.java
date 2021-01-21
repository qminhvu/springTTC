package spring.excercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.excercise.Model.DTO.ClassCreate;

import spring.excercise.Model.Entities.Class;

import spring.excercise.Model.Entities.Student;
import spring.excercise.Service.ClassService;
import spring.excercise.repositories.StudentRepo;


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
    public List<Student> readOne(@PathVariable("id") int id) {
        return (List<Student>) service.readByID(id);
    }

    @PutMapping("/{id}")
    public Class replaceClass(@RequestBody Class classEntity, @PathVariable int id) {
        return service.replaceClass(classEntity, id);
    }

    @PostMapping
    public Class create(@RequestBody ClassCreate classCreate) throws Exception {
        return service.create(classCreate);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
