import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise3
 * Create a class Restaurant. Create an interface HotDrink with an abstract method prepareHotDrink.
 * Create two classes Tea and ExpressTea which implements HotDrink Class.
 * Create an instance variable of type HotDrink in Restaurant class.
 * Configure Tea and ExpressTea classes beans in Spring XML. create a bean with the name teaRestaurant of type
 * Restaurant which inject Tea object as dependency using setter method.
 *
 * Exercise4
 * Get both the beans and invoke prepareHotDrink method via hotDrink
 * instance variables. Try inner bean with expressTeaRestaurant.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("restaurant-config.xml");
        HotDrink hotDrink = (HotDrink) applicationContext.getBean("tea");
        System.out.println(hotDrink.prepareHotDrink());
        HotDrink hotDrink1 = (HotDrink) applicationContext.getBean("expressTea");
        System.out.println(hotDrink1.prepareHotDrink());
        Restaurant restaurant= (Restaurant) applicationContext.getBean("teaRestaurant");
        System.out.println(restaurant);
        Restaurant restaurant1= (Restaurant) applicationContext.getBean("expressTeaRestaurant");
        System.out.println(restaurant1);
    }
}
