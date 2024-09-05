package org.example.ordermanagement.service;

import org.example.ordermanagement.controller.dto.OrderDetails;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.orderexceptionhandler.OrderNotFoundExceptionHandler;
import org.example.ordermanagement.exception.orderitemexceptionhandler.OrderItemNotFoundExceptionHandler;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.projections.OrderItemProjections;
import org.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public OrderDetails getOrderById(Long id) {

        Optional<Order> order = orderRepository.findById(id);
        List<OrderItemProjections> orderItemProjections = orderRepository.findOrderItemByOrderId(id);

        if (order.isEmpty()) {
            throw new OrderNotFoundExceptionHandler("Order with id : " + id + " is not found ", Code.ORDER_NOT_FOUND);
        }
        if (orderItemProjections.isEmpty()) {
            throw new OrderItemNotFoundExceptionHandler(" No products for following id : " + id, Code.PRODUCTS_NOT_FOUND);
        }

        return new OrderDetails(order.get(), orderItemProjections);
    }


    public Long createOrder(Order order) {
        orderRepository.save(order);
        return order.getId();
    }


}
