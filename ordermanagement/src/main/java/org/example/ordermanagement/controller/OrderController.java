package org.example.ordermanagement.controller;

import org.apache.coyote.Request;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

}
