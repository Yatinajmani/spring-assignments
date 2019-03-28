package ttn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ttn.spring.entities.Student;
import ttn.spring.entities.Student2;
import ttn.spring.exceptions.StudentNotFoundException;
import ttn.spring.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    String getGreetings(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        System.out.println(locale);
        return messageSource.getMessage("greetings", null,
                locale != null ? locale : LocaleContextHolder.getLocale());
    }

    @GetMapping({"/", ""})
    List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    Student getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found!!");
        }
        return studentService.getStudentById(id);
    }

    @PutMapping({"/", ""})
    Student updateStudentById(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping(value = {"/", ""}, produces = MediaType.APPLICATION_XML_VALUE)
    Student saveStudent(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "/student", headers = "API-VERSION=2")
    Student2 getStudent2Header2() {
        return new Student2("Yatin", "Ajmani", 5, 65456435L);
    }

    @GetMapping(value = "/student", headers = "API-VERSION=1")
    Student getStudentHeader1() {
        return new Student("Yatin", 5, 65456435L);
    }

}
