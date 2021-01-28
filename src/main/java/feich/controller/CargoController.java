package feich.controller;

import feich.model.CargoWithPoints;
import feich.model.Order;
import feich.model.RoutePoint;
import feich.service.OrderService;
import feich.service.RoutePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feich.model.Cargo;
import feich.service.CargoService;

import java.util.List;

@Controller
public class CargoController {

    private CargoService cargoService;
    private RoutePointService routePointService;

    @Autowired
    public void setRoutePointService(RoutePointService routePointService) {
        this.routePointService = routePointService;
    }

    @Autowired
    public void setCargoService(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @RequestMapping(value = "/cargoes", method = RequestMethod.GET)
    public ModelAndView allCargoes() {
        List<Cargo> cargoes = cargoService.allCargoes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @RequestMapping(value = "/cargoes/{id}", method = RequestMethod.GET)
    public ModelAndView thisCargoes(@PathVariable Long id) {
        List<Cargo> cargoes = cargoService.cargoesForTruck(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @RequestMapping(value = "/cargoesForShipment/{id}", method = RequestMethod.GET)
    public ModelAndView cargoesForShipment(@PathVariable Long id) {
        List<Cargo> cargoes = cargoService.cargoesForShipment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @RequestMapping(value = "/cargoesForDischarge/{id}", method = RequestMethod.GET)
    public ModelAndView cargoesForDischarge(@PathVariable Long id) {
        List<Cargo> cargoes = cargoService.cargoesForDischarge(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @GetMapping(value = "/cargoesInOrder/{id}")
    public ModelAndView cargoesInOrder(@PathVariable Long id) {
        List<Cargo> cargoes = cargoService.cargoesInOrder(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cargoes");
        modelAndView.addObject("cargoesList", cargoes);
        return modelAndView;
    }

    @GetMapping(value = "/editCargo/{id}")
    public ModelAndView editCargoPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCargo");
        modelAndView.addObject("cargo", cargoService.getById(id));
        modelAndView.addObject("routePoints", routePointService.allRoutePoints());
        modelAndView.addObject("currentShipmentPoint", cargoService.currentShipmentPoint(id));
        modelAndView.addObject("currentDischargePoint", cargoService.currentDischargePoint(id));
        return modelAndView;
    }

    @PostMapping(value = "/editCargo")
    public  ModelAndView editCargo(@ModelAttribute("cargoWithPoints") CargoWithPoints cargoWithPoints) {
        cargoService.editCargo(cargoWithPoints);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
        return modelAndView;
    }

    @GetMapping(value = "/addCargo")
    public  ModelAndView addCargoPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCargo");
        return modelAndView;
    }

    @PostMapping(value = "/addCargo")
    public void addCargo(@ModelAttribute Cargo cargo) {
        cargoService.add(cargo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
    }

    @PostMapping(value = "/addCargoWithPoints/{orderId}")
    public void addCargoWithPoints(@ModelAttribute("cargoWithPoints") CargoWithPoints cargoWithPoints, @PathVariable("orderId") Long orderId) {
        cargoService.saveCargo(cargoWithPoints, orderId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
    }

    @GetMapping(value = "/deleteCargo/{id}")
    public ModelAndView deleteCargo(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cargoes");
        cargoService.delete(cargoService.getById(id));
        return modelAndView;
    }
}
