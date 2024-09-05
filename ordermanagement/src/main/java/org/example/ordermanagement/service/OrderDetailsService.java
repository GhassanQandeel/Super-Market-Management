package org.example.ordermanagement.service;

import org.example.ordermanagement.controller.dto.OrderDto;
import org.example.ordermanagement.controller.dto.ProductDto;
import org.example.ordermanagement.mapper.ProductMapper;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.projections.OrderItemsProjections;
import org.example.ordermanagement.repository.OrderItemRepository;
import org.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    public OrderDto getOrderById(Long id) {


        Order order = orderRepository.findById(id).orElse(null);
        List<ProductDto> productDtoList = new ArrayList<>();


        // return all products of the order
        orderItemRepository.findByOrderId(id).forEach(orderItemsProjections -> productDtoList.add(
                new ProductDto(
                        orderItemsProjections.getId(),
                        orderItemsProjections.getName(),
                        orderItemsProjections.getSellingPrice(),
                        orderItemsProjections.getQuantity())));


        // calculate total salary
        int totalAmount = productDtoList.stream().mapToInt(productDto -> (productDto.getPrice() * productDto.getQuantity())).sum();

        // insert all order details
        assert order != null;
        return new OrderDto(
                order.getId(),
                order.getCashierId(),
                order.getCreatedAt(),
                order.getCustomer().getId(),
                order.getCustomer().getName(),
                order.getCustomer().getCity(),
                order.getStatus(),
                order.getAmountPaid(),
                productDtoList,
                totalAmount);

    }


}
