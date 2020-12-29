package test.controller;

import model.Cargo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.service.CargoService;

import java.util.List;

@Controller
public class TrucksAndCargoesController {
    private CargoService cargoService = new CargoService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allTrucks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trucks");
        return modelAndView;
    }

    @RequestMapping(value = "/cargoes", method = RequestMethod.GET)
    public ModelAndView allCargoes() {
        List<Cargo> cargoes = cargoService.allCargoes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @GetMapping(value = "/editCargo{id}")
    public  ModelAndView editCargoPage(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCargo");
        modelAndView.addObject("cargo", cargoService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/editCargo")
    public  ModelAndView editCargo(@ModelAttribute Cargo cargo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
        cargoService.edit(cargo);
        return modelAndView;
    }

    @GetMapping(value = "/addCargo")
    public  ModelAndView addCargoPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCargo");
        return modelAndView;
    }

    @PostMapping(value = "/addCargo")
    public  ModelAndView addCargo(@ModelAttribute Cargo cargo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
        cargoService.add(cargo);
        return modelAndView;
    }

    @GetMapping(value = "/deleteCargo/{id}")
    public ModelAndView deleteCargo(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
        cargoService.delete(cargoService.getById(id));
        return modelAndView;
    }
}
