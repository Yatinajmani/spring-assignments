package com.ttn.springboot.repository;

import com.ttn.springboot.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findById(int id);
}
