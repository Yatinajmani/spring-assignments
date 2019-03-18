package com.ttn.springboot.controller;

import com.ttn.springboot.entity.Database;
import com.ttn.springboot.entity.Student;
import com.ttn.springboot.entity.User;
import com.ttn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    private User user;

    @Autowired
    private Database database;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student addStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping("/view/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @RequestMapping("/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Student updateStudent(Student student, @PathVariable int id) {
        Student student1 = studentService.getStudent(id);
        if (student1 != null)
            return studentService.saveStudent(student);
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        if (student != null)
            studentService.deleteStudent(student);
    }

    @RequestMapping("/user")
    public User getUser() {
        return user;
    }

    @RequestMapping("/database")
    public Database getDatabase() {
        return database;
    }

}
