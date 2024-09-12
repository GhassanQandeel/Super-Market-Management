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
    private PriceService priceService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;


    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }



    public Order addOrderItem(OrderItem orderItem) {
        OrderItem orderItemSaved = new OrderItem();
        orderItemSaved.setProduct(productService.getProductById(orderItem.getProduct().getId()));
        orderItemSaved.setOrder(orderRepository.findById(orderItem.getOrder().getId()).get());
        orderItemSaved.setPrice(priceService.getPrice(orderItemSaved.getProduct().getPrice().getId()));
        orderItemSaved.setQuantity(orderItem.getQuantity());
        orderItemRepository.save(orderItemSaved);

       Order order = orderService.getOrderById(orderItemSaved.getOrder().getId());
       return order;
    }

    public List<OrderItem> getOrderItemsByOrderId(long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }


    public int getOrderItemTotalPrice(Long orderId){

        List<OrderItem> items = getOrderItemsByOrderId(orderId);
        int totalPrice;
        totalPrice=items.stream().mapToInt(orderItem -> (orderItem.getQuantity()*orderItem.getPrice().getSellingPrice())).sum();
        return totalPrice;
    }

}
