import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
