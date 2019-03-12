import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Create Class Complex as follows:
 * class complex {
 * List list;
 *
 * Set set;
 *
 * Map map;
 *
 * }
 * Initialize all the instance variables of the complex class using Spring XML. Give bean name as
 * complexBean. Get the bean and display the properties.
 */
public class Application {
    static final Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("complex-config.xml");
        logger.info(applicationContext.getBean("complexBean").toString());
    }
}
