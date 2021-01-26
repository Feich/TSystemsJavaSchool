package feich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feich.model.Truck;
import feich.service.TruckService;
import feich.service.exception.TruckNumberException;

import java.util.List;

@Controller
public class TruckController {
    private TruckService truckService;

    @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }


    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public ModelAndView allTrucks() {
        List<Truck> trucks = truckService.allTrucks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trucks");
        modelAndView.addObject("trucksList", trucks);
        return modelAndView;
    }

    @GetMapping(value = "/truckInOrder/{id}")
    public ModelAndView truckInOrder(@PathVariable Long id) {
        List<Truck> trucks = truckService.truckInOrder(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trucks");
        modelAndView.addObject("trucksList", trucks);
        return modelAndView;
    }

    @GetMapping(value = "/editTruck/{id}")
    public ModelAndView editTruckPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTruck");
        modelAndView.addObject("truck", truckService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/editTruck")
    public ModelAndView editTruck(@ModelAttribute("truck") Truck truck) {
        truckService.edit(truck);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/trucks");
        return modelAndView;
    }

    @GetMapping(value = "/addTruck")
    public ModelAndView addTruckPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTruck");
        return modelAndView;
    }

    @PostMapping(value = "/addTruck")
    public ModelAndView addTruck(@ModelAttribute Truck truck) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            truckService.add(truck);
        } catch (TruckNumberException e) {
            modelAndView.setViewName("editTruck");
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/trucks");
        return modelAndView;
    }

    @GetMapping(value = "/deleteTruck/{id}")
    public ModelAndView deleteTruck(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/trucks");
        truckService.delete(truckService.getById(id));
        return modelAndView;
    }
}
