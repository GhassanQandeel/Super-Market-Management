package org.example.ordermanagement.controller;


import org.example.ordermanagement.controller.dto.OrderDto;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.service.CustomerService;
import org.example.ordermanagement.service.OrderDetailsService;
import org.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;


    @GetMapping
    public OrderDto getAllOrders(@RequestParam Long id ) {
        return orderDetailsService.getOrderById(id);
    }


    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

}
