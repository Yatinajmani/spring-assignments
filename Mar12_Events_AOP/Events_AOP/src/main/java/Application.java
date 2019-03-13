import entity.Database;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("database-config.xml");
        //Exercise1
        applicationContext.start();
        Database database = applicationContext.getBean("database", Database.class);
        System.out.println("Instance : " + database);
        try {
            database.connectService();
        } catch (IOException e) {
        }

        database.setPort(27017);
        System.out.println("Port Updated : " + database.getPort());

        //Exercise1
        applicationContext.stop();

        //Exercise1
        applicationContext.close();
    }
}
