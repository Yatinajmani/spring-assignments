package ttn.spring.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/exercise1")
    public String getExercise1(){
        return "Exercise1";
    }
}
