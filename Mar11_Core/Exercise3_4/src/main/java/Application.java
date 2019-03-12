import component.HotDrink;
import component.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise3
 * Create a class Restaurant. Create an interface HotDrink with an abstract method prepareHotDrink.
 * Create two classes Tea and ExpressTea which implements HotDrink Class.
 * Create an instance variable of type HotDrink in Restaurant class.
 * Configure Tea and ExpressTea classes beans in Spring XML. create a bean with the name teaRestaurant of type
 * Restaurant which inject Tea object as dependency using setter method.
 * <p>
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
        Restaurant restaurant = (Restaurant) applicationContext.getBean("teaRestaurant");
        System.out.println(restaurant);
        Restaurant restaurant1 = (Restaurant) applicationContext.getBean("expressTeaRestaurant");
        System.out.println(restaurant1);
        Restaurant teaRestaurantByConstructor = (Restaurant) applicationContext.getBean("teaRestaurantByConstructor");
        System.out.println(teaRestaurantByConstructor);
        Restaurant expressTeaRestaurantByName = (Restaurant) applicationContext.getBean("expressTeaRestaurantByName");
        System.out.println(expressTeaRestaurantByName);


        ApplicationContext applicationContextForTypeAutowiring =
                new ClassPathXmlApplicationContext("restaurant-autowire-type-config.xml");
        Restaurant teaRestaurantByType =
                (Restaurant) applicationContextForTypeAutowiring.getBean("teaRestaurantByType");
        System.out.println(teaRestaurantByType);

        Restaurant teaRestaurant = (Restaurant) applicationContext.getBean("teaRestaurant");
        System.out.println("Checking prototype scope as references equality gives : " + (restaurant == teaRestaurant));

        ApplicationContext applicationContextForAnnotation =
                new ClassPathXmlApplicationContext("restaurant-annotation-autowiring.xml");

        Restaurant teaRestaurantBySetterAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantBySetterAnnotation");
        System.out.println("Using Setter Autowire" + teaRestaurantBySetterAnnotation);

        Restaurant teaRestaurantByFieldAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantByFieldAnnotation");
        System.out.println("Using Field Autowire" + teaRestaurantByFieldAnnotation);

        Restaurant teaRestaurantByAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantByAnnotation");
        System.out.println("Using Constructor Autowire" + teaRestaurantByAnnotation);

        Restaurant restaurantAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("restaurantAnnotation");
        System.out.println("Using Component Annotation" + restaurantAnnotation);

    }
}
