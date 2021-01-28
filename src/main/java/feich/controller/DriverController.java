package feich.controller;

import feich.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feich.model.Driver;

import java.util.List;

@Controller
public class DriverController {

    private DriverService driverService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public ModelAndView allDrivers() {
        List<Driver> drivers = driverService.allDrivers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("drivers");
        modelAndView.addObject("driversList", drivers);
        return modelAndView;
    }

    @GetMapping(value = "/editDriver/{id}")
    public ModelAndView editDriverPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editDriver");
        modelAndView.addObject("driver", driverService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/editDriver")
    public  ModelAndView editDriver(@ModelAttribute("driver") Driver driver) {
        driverService.edit(driver);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/drivers");
        return modelAndView;
    }

    @GetMapping(value = "/addDriver")
    public  ModelAndView addDriverPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editDriver");
        return modelAndView;
    }

    @PostMapping(value = "/addDriver")
    public  ModelAndView addDriver(@ModelAttribute Driver driver) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/drivers");
        driverService.add(driver);
        return modelAndView;
    }

    @GetMapping(value = "/deleteDriver/{id}")
    public ModelAndView deleteDriver(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/drivers");
        driverService.delete(id);
        return modelAndView;
    }

    @GetMapping(value = "/driversInOrder/{id}")
    public ModelAndView driversInOrder(@PathVariable Long id) {
        List<Driver> drivers = driverService.driversInOrder(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("drivers");
        modelAndView.addObject("driversList", drivers);
        return modelAndView;
    }
}
