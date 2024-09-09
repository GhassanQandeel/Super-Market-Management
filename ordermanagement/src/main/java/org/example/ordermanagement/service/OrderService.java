package org.example.ordermanagement.service;

import org.example.ordermanagement.controller.requestdto.order.OrderFinalizeRequestDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderNotFoundExceptionHandler;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.Status;
import org.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public Order getOrderById(Long id) {

        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            throw new OrderNotFoundExceptionHandler("Order with id : " + id + " is not found ", Code.ORDER_NOT_FOUND);
        }


        return order.get();
    }

    public List<Long> getOrderIds() {
        List<Order> orders = orderRepository.findAll();
        List<Long> orderIds = new ArrayList<>();
        for (Order order : orders) {
            orderIds.add(order.getId());
        }
        return orderIds;
    }


    public Long createOrder(Order order) {
        orderRepository.save(order);
        return order.getId();
    }



    public Order finalizeOrder(Long id, OrderFinalizeRequestDto orderFinalizeRequestDto) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new OrderNotFoundExceptionHandler("Order with id : " + id + " is not found ", Code.ORDER_NOT_FOUND);
        }
        order.get().setStatus(Status.NOT_EDITABLE);
        order.get().setAmountPaid(orderFinalizeRequestDto.getAmountPaid());
        orderRepository.save(order.get());
        return order.get();
    }


}
