import config.ApplicationConfiguration;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.PersonRepository;


/**
 * Perform all the methods inside CrudRepository for Person Class.
 * Use the methods declared above to fetch the person.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        PersonRepository personRepository = (PersonRepository) context.getBean("personRepository");
        personRepository.save(new Person("yatin", "ajmani", 54, 450000));
        personRepository.save(new Person("yatin", "", 54, 450000));
        personRepository.findAll().forEach(System.out::println);
        System.out.println(personRepository.findById(1));
        System.out.println(personRepository.findByFirstName("yatin"));
        System.out.println(personRepository.findByLastName("ajmani"));
    }
}
