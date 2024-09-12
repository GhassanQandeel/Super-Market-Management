package org.example.ordermanagement.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.ordermanagement.controller.requestdto.order.OrderFinalizeRequestDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderNotFoundException;

import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.model.Status;

import org.example.ordermanagement.repository.CustomerRepository;
import org.example.ordermanagement.repository.OrderItemRepository;
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
    @Autowired
    private OrderItemRepository orderItemRepository;



    public Order getOrderById(Long id) {

        Optional<Order> order = Optional.ofNullable(orderRepository.findOrderById(id));

        if (order.isEmpty()) {
            throw new OrderNotFoundException("Order with id : " + id + " is not found ", Code.ORDER_NOT_FOUND);
        }
        Order order1 = order.get();
        List<OrderItem> orderItems =orderItemRepository.findByOrderId(order1.getId());

        order1.setOrderItems(orderItems);
        order1.setTotalPrice(orderItems.stream().mapToInt(orderItem -> orderItem.getPrice().getSellingPrice()*orderItem.getQuantity()).sum());
        return order1;
    }

    public List<Long> getOrderIds() {
        List<Order> orders = orderRepository.findAll();
        List<Long> orderIds = new ArrayList<>();
        for (Order order : orders) {
            orderIds.add(order.getId());
        }
        return orderIds;
    }



    @Autowired
    private CustomerRepository customerRepository;

    public Order createOrder(Order order) {

        Customer customer = customerRepository.findById(order.getCustomer().getId()).get();

        order.setCustomer(customer);

        order = orderRepository.saveAndFlush(order);

        order = getOrderById(order.getId());

        return order;
    }

    public Order finalizeOrder(Long id, OrderFinalizeRequestDto orderFinalizeRequestDto) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new OrderNotFoundException("Order with id : " + id + " is not found ", Code.ORDER_NOT_FOUND);
        }
        Order order1 = order.get();

        order1.setStatus(Status.NOT_EDITABLE);
        order1.setAmountPaid(orderFinalizeRequestDto.getAmountPaid());

        orderRepository.save(order1);
        return getOrderById(order1.getId());
    }


}
