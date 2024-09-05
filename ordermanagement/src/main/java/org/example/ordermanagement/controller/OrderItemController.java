package org.example.ordermanagement.controller;

import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }
    @PostMapping
    public void addOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.addOrderItem(orderItem);
    }


}
