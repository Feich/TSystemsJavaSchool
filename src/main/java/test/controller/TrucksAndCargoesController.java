package test.controller;

import model.Cargo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrucksAndCargoesController {
    private static Cargo cargo = new Cargo(1, "Kaspisky", 2.5F, "OK");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allTrucks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trucks");
        return modelAndView;
    }

    @RequestMapping(value = "/cargoes", method = RequestMethod.GET)
    public ModelAndView editCargo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargo", cargo);
        return modelAndView;
    }

}
