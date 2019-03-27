package ttn.spring.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ttn.spring.thymeleaf.entity.Employee;

import java.util.Arrays;

@Controller
public class DefaultController {
    @GetMapping("/exercise1")
    public String getExercise1() {
        return "Exercise1";
    }

    @GetMapping("/exercise2")
    public String getExercise2() {
        return "Exercise2";
    }

    @GetMapping("/exercise3")
    public String getRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "Exercise3";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerEmployee(Employee employee) {
        System.out.println(employee);
        return employee.toString();
    }

    @GetMapping("/exercise4")
    public String getEmployees(Model model) {
        model.addAttribute("employees", Arrays.asList(new Employee("Yatin", 24, 954646511L)
                , new Employee("Siddharth", 24, 9546465158L)));
        return "Exercise4";
    }

    @GetMapping("/exercise5")
    public String getAdmin(Model model) {
        model.addAttribute("employees", Arrays.asList(new Employee("Yatin",
                24, 954646511L, false), new Employee("Siddharth",
                24, 9546465158L, true)));
        return "Exercise5";
    }

}
