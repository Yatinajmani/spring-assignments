package controller;

import co.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

////Exercise 1
//public class StudentController extends AbstractController {
//    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return new ModelAndView("index");
//    }
//}


////Exercise 2
//public class StudentController extends MultiActionController {
//
//    public ModelAndView index(HttpServletRequest httpServletRequest,
//                              HttpServletResponse httpServletResponse) throws Exception {
//        return new ModelAndView("index");
//    }
//
//    public void hello(HttpServletRequest httpServletRequest,
//                       HttpServletResponse httpServletResponse) throws Exception {
//        httpServletResponse.setContentType("text/html");
//        httpServletResponse.getWriter().println("Exercise 2");
//    }
//
//}

@Controller
public class StudentController {
    //Exercise 3
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    //Exercise 4
    @RequestMapping("hello")
    @ResponseBody
    public String getHello() {
        return "Hello World";
    }

    //Exercise 5
    @RequestMapping("hello2")
    public ModelAndView getHello2() {
        ModelAndView index = new ModelAndView("index");
        index.addObject("hello", "Hello World.");
        return index;
    }

    //Exercise 6,7
    @RequestMapping("name/{firstname}/{lastname}")
    @ResponseBody
    public String getName(@PathVariable Map<String, String> name) {
        return name.get("firstname") + name.get("lastname");
    }

    //Exercise 8
    @RequestMapping("form")
    public String getForm() {
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    @ResponseBody
    public String formData(@RequestParam Map<String, String> name) {
        return name.get("firstname") + name.get("lastname");
    }

    //Exercise 9
    @RequestMapping(value = "newStudent", method = RequestMethod.POST)
    @ResponseBody
    public String submitStudent(Student student) {
        return student.toString();
    }

    //Exercise 10
    @ModelAttribute
    public void addHeading(Model model) {
        model.addAttribute("heading", "Spring MVC Demo");
    }
}
