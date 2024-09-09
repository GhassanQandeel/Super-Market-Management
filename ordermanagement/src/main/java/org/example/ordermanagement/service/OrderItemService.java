package org.example.ordermanagement.service;

import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;


    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }



    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getOrderItemsByOrderId(long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }


    public String getOrderItemTotalPrice(Long orderId){

        List<OrderItem> items =getOrderItemsByOrderId(orderId);
        int totalPrice;
        totalPrice=items.stream().mapToInt(orderItem -> (orderItem.getQuantity()*orderItem.getPrice().getSellingPrice())).sum();
        return "the total price for order ID "+orderId+" is "+totalPrice;
    }

}
