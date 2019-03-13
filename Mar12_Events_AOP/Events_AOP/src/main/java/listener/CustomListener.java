package listener;

import event.CustomEvent;
import org.springframework.context.ApplicationListener;

//Exercise3
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Database Connected.");
    }
}
