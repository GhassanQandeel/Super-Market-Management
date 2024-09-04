package org.example.ordermanagement.service;

import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;



    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}
