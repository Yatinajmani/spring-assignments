package ttn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ttn.spring.entities.Student2;
import ttn.spring.exceptions.StudentNotFoundException;
import ttn.spring.service.Student2Service;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("students/v2")
public class Student2Controller {
    @Autowired
    Student2Service studentService;

    @GetMapping({"/", ""})
    List<Student2> getStudent2s() {
        return studentService.getAllStudent2s();
    }

    @GetMapping("/{id}")
    Student2 getStudent2ById(@PathVariable Long id) {
        Student2 student = studentService.getStudent2ById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found!!");
        }
        return studentService.getStudent2ById(id);
    }

    @PutMapping({"/", ""})
    Student2 updateStudent2ById(@Valid @RequestBody Student2 student) {
        studentService.saveStudent2(student);
        return student;
    }

    @PostMapping(value = {"/", ""})
    Student2 saveStudent2(@Valid @RequestBody Student2 student) {
        studentService.saveStudent2(student);
        return student;
    }

    @DeleteMapping("/{id}")
    void deleteStudent2(@PathVariable Long id) {
        studentService.deleteStudent2(id);
    }

}
