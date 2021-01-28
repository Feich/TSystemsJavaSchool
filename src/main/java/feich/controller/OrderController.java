package feich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feich.model.Order;
import feich.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView allOrders() {
        List<Order> orders = orderService.allOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders");
        modelAndView.addObject("ordersList", orders);
        return modelAndView;
    }

    @GetMapping(value = "/editOrder/{id}")
    public ModelAndView editOrderPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editOrder");
        modelAndView.addObject("order", orderService.getById(id));
        return modelAndView;
    }

    @GetMapping(value = "/orderByRoutePoint/{id}")
    public ModelAndView orderByRoutePoint(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders");
        List<Order> ordersList = orderService.orderByRoutePoint(id);
        modelAndView.addObject("order", ordersList);
        return modelAndView;
    }

    @PostMapping(value = "/editOrder")
    public  ModelAndView editOrder(@ModelAttribute("order") Order order) {
        orderService.edit(order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/orders");
        return modelAndView;
    }

    @GetMapping(value = "/addOrder")
    public  ModelAndView addOrderPage() {
        Order newOrder = orderService.add(new Order("CREATED"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editOrder");
        modelAndView.addObject("order", newOrder);
        return modelAndView;
    }

    @PostMapping(value = "/addOrder")
    public  ModelAndView addOrder() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/orders");
        return modelAndView;
    }

    @GetMapping(value = "/deleteOrder/{id}")
    public ModelAndView deleteOrder(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/orders");
        orderService.delete(id);
        return modelAndView;
    }
}
