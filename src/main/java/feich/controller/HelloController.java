package feich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping(value = "/")
    public ModelAndView helloPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("helloPage");
        return modelAndView;
    }
}
