package repository;

import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


/**
 * Implement CrudRepository for it.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
