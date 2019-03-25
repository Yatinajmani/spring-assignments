package repository;

import entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * 2.Implement CrudRepository for it.
 * 4.For class Person find person declare methods in repository to find person by firstname, lastname and Id.
 * 6.Use @Query to fetch firstname of the Person whose age is 25.
 * 7.Use @Query to fetch firstname and lastname of the Person whose age is 25.
 * 8.Get complete information of the Employee whose age is 25 using @Query.
 * 9.Count Person where name is "Peter" using @Query.
 */
//  Exercise 2
public interface PersonRepository extends CrudRepository<Person, Integer> {
    //  Exercise 4
    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Person findById(Integer id);

    //  Exercise 6
    @Query("select firstName from Person where age=25")
    List<Person> findByAgeViaQuery();

    //  Exercise 7
    @Query("select CONCAT(p.firstName, ' ', p.lastName) as fullname from Person p where age=25")
    List<String> findFullNameWithAge25ViaQuery();

    //  Exercise 8
    @Query("from Person where age=25")
    List<Person> findPersonWithAgeViaQuery();

    //  Exercise 9
    @Query("select count(*) from Person where firstName='Peter'")
    Integer findPersonWithNamePeterViaQuery();

}
