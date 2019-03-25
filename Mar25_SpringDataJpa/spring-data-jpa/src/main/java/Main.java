import config.ApplicationConfiguration;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 3.Perform all the methods inside CrudRepository for Person Class.
 * 5.Use the methods declared above to fetch the person.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        PersonRepository personRepository = (PersonRepository) context.getBean("personRepository");

//      Exercise 3
//      Using save(S entity)
        personRepository.save(new Person("yatin", "ajmani", 24, 450000));

//      Using save(Iterable<S> entities)
        List<Person> people = Arrays.asList(new Person("yatin", "ajmani", 25, 430000),
                new Person("harsh", "jain", 25, 420000),
                new Person("fName", "lName", 24, 420000),
                new Person("Peter", "parker", 26, 410000));
        personRepository.save(people);

//      Using findOne(ID id)
        System.out.println(personRepository.findOne(1));

//      Using exists(ID id)
        System.out.println(personRepository.exists(1));

//      Using findAll()
        System.out.println("=====================Find All Records=====================");
        personRepository.findAll().forEach(System.out::println);

//      Using findAll(Iterable<ID> ids)
        System.out.println("=====================Find All Records having ids 2,3,4.=====================");
        personRepository.findAll(people.stream().map(Person::getId).collect(Collectors.toList()))
                .forEach(System.out::println);
//      Using count()
        System.out.println("No. of Persons : " + personRepository.count());

//      Using delete(ID id)
        personRepository.delete(4);

//      Using delete(T entity)
        personRepository.delete(personRepository.findById(1));

//      Using delete(Iterable<? extends T> entities)
        personRepository.delete(Arrays.asList(people.get(0), people.get(1)));

//      Using deleteAll()
        personRepository.deleteAll();

        personRepository.save(people);

//      Exercise 5
        System.out.println("Person with Id 6 : " + personRepository.findById(6));
        System.out.println("Persons with FirstName yatin : " + personRepository.findByFirstName("yatin"));
        System.out.println("Persons with lastName ajmani : " + personRepository.findByLastName("ajmani"));


//      Exercise 6
        System.out.println("Persons with age = 25 : " + personRepository.findByAgeViaQuery());

//      Exercise 7
        System.out.println("Persons full Name with age = 25 : ");
        personRepository.findFullNameWithAge25ViaQuery().forEach(System.out::println);

//      Exercise 8
        System.out.println("Persons with age = 25 : ");
        personRepository.findPersonWithAgeViaQuery().forEach(System.out::println);

//      Exercise 9
        System.out.println("Persons with first Name = Peter : " + personRepository.findPersonWithNamePeterViaQuery());

//      Exercise 10
        System.out.println("Persons with age = 25, Using count : " + personRepository.countAllByAge(25));

        System.out.println("Persons with age = 26 or firstName = yatin, Using distinct : " + personRepository
                .getDistinctByFirstNameOrAge("yatin", 26));

        System.out.println("Persons with age = 25 and firstName = yatin, Using distinct : " + personRepository
                .getAllByFirstNameAndAge("yatin", 25));

        System.out.println("Persons age between 25 and 28= yatin, Using distinct : " + personRepository
                .getByAgeBetween(25, 28));

        System.out.println("Persons salary less than 420000 : " + personRepository
                .getBySalaryLessThan(420000));

        System.out.println("Persons salary greater than 420000 : " + personRepository
                .getBySalaryGreaterThan(420000));

        System.out.println("Persons with name like yatin : " + personRepository
                .getByFirstNameLike("yatin"));

        System.out.println("Persons with name not like yatin : " + personRepository
                .getByFirstNameNot("yatin"));

        System.out.println("Persons with name not like yatin : " + personRepository
                .getByFirstNameIn(Arrays.asList("yatin", "harsh")));

        System.out.println("Persons with name YATIN ignoring case : " + personRepository
                .getByFirstNameIgnoreCase("YATIN"));

//      Exercise 11
        System.out.println("Persons with age greater than 25 sorted by descending order by id : " + personRepository
                .findByAgeGreaterThanOrderByIdDesc(25));

//      Exercise 12
        System.out.println("Persons with age greater than 25 sorted by descending order by id using sort class : "
                + personRepository.findByAge(25, new Sort(Sort.Direction.DESC, "id")));

//      Exercise 13
        Page<Person> personPage = personRepository.findAll((new PageRequest(0, 2)));
        System.out.println("Paginated Persons : " + personPage);
        System.out.println(personPage.getContent());

    }
}
