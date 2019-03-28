package ttn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ttn.spring.entities.Student;
import ttn.spring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping({"/", ""})
    List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping({"/", ""})
    Student updateStudentById(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping({"/", ""})
    Student saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
