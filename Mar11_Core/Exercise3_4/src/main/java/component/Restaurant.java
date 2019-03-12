package component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component("restaurantAnnotation")
public class Restaurant {
    @Autowired
    HotDrink hotDrink;

    public Restaurant() {
    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    @Required
    @Autowired
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Autowired
    public Restaurant(HotDrink hotDrink1) {
        this.hotDrink = hotDrink1;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "hotDrink=" + hotDrink.prepareHotDrink() +
                '}';
    }
}
