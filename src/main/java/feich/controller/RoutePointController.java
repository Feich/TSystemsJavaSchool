package feich.controller;

import feich.service.RoutePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feich.model.RoutePoint;

import java.util.List;

@Controller
public class RoutePointController {

    private RoutePointService routePointService;

    @Autowired
    public void setRoutePointService(RoutePointService routePointService) {
        this.routePointService = routePointService;
    }

    @RequestMapping(value = "/routePoints", method = RequestMethod.GET)
    public ModelAndView allRoutePoints() {
        List<RoutePoint> routePoints = routePointService.allRoutePoints();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("routePoints");
        modelAndView.addObject("routePointsList", routePoints);
        return modelAndView;
    }

    @GetMapping(value = "/editRoutePoint/{id}")
    public ModelAndView editRoutePointPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editRoutePoint");
        modelAndView.addObject("routePoint", routePointService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/editRoutePoint")
    public  ModelAndView editRoutePoint(@ModelAttribute("routePoint") RoutePoint routePoint) {
        routePointService.edit(routePoint);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/routePoints");
        return modelAndView;
    }

    @GetMapping(value = "/addRoutePoint")
    public  ModelAndView addRoutePointPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editRoutePoint");
        return modelAndView;
    }

    @PostMapping(value = "/addRoutePoint")
    public  ModelAndView addRoutePoint(@ModelAttribute RoutePoint routePoint) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/routePoints");
        routePointService.add(routePoint);
        return modelAndView;
    }

    @GetMapping(value = "/deleteRoutePoint/{id}")
    public ModelAndView deleteRoutePoint(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/routePoints");
        routePointService.delete(routePointService.getById(id));
        return modelAndView;
    }

    @GetMapping(value = "/routePointsInOrder/{id}")
    public ModelAndView routePointsInOrder(@PathVariable Long id) {
        List<RoutePoint> routePoints = routePointService.routePointsInOrder(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("routePoints");
        modelAndView.addObject("routePointsList", routePoints);
        return modelAndView;
    }
}
