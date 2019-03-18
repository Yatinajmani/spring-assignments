package com.ttn.springboot.service;

import com.ttn.springboot.entity.Student;
import com.ttn.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id);
    }
}
