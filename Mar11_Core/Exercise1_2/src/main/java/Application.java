import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise1
 * Create a class Database with 2 instance variables port and name. Configure Database class bean in spring container
 * through Spring XML. Initialize instance variables using setter method.
 *
 * Exercise2
 * Get the bean of the class from spring container and print the values of the instance variable.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("database-config.xml");
        System.out.println(applicationContext.getBean("database"));
    }
}
