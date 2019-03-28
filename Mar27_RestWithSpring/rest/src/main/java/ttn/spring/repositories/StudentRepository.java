package ttn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ttn.spring.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
