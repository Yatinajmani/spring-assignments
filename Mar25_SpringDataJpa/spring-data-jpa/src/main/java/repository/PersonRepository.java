package repository;

import entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Implement CrudRepository for it.
 * For class Person find person declare methods in repository to find person by firstname, lastname and Id.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Person findById(Integer id);
}
