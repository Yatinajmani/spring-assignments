package com.ttn.springboot.service;

import com.ttn.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student saveStudent(Student student);

    void deleteStudent(Student student);

    Student getStudent(int id);
}
