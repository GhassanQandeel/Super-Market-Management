package org.example.ordermanagement.service;

import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.repository.OrderItemRepository;
import org.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderService orderService;


    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }



    public Order addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return orderService.getOrderById(orderItem.getOrder().getId());
    }

    public List<OrderItem> getOrderItemsByOrderId(long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }


    public int getOrderItemTotalPrice(Long orderId){

        List<OrderItem> items =getOrderItemsByOrderId(orderId);
        int totalPrice;
        totalPrice=items.stream().mapToInt(orderItem -> (orderItem.getQuantity()*orderItem.getPrice().getSellingPrice())).sum();
        return totalPrice;
    }

}
