package spring.excercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.excercise.Model.DTO.StudentDTO;
import spring.excercise.Model.Entities.Student;
import spring.excercise.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    Student readOne(@PathVariable int id) {
        return service.readByID(id);
    }

    @PutMapping("/{id}")
    Student replaceStudent(@RequestBody Student student, @PathVariable int id) {
        return service.replaceStudent(student, id);
    }

    @PostMapping
    public Student create(@RequestBody StudentDTO studentDTO) throws Exception {
        return service.create(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
