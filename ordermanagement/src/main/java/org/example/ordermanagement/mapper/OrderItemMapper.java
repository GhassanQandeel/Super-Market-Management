package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.dto.orderitem.OrderItemDto;
import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.model.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel="spring")
abstract public class OrderItemMapper {


    public OrderItem toOrderItem(Long id ,OrderItemAdditionRequestDto requestDto){
        OrderItem orderItem = new OrderItem();
        Order order =new Order();
        Product product =new Product();

        order.setId(id);
        product.setId((long)requestDto.getProductId());




        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(requestDto.getQuantity());

        return orderItem;

    }



    public OrderItemDto toOrderItem(OrderItem orderItem) {
        OrderItemDto orderItemResponse = new OrderItemDto();

        orderItemResponse.setProductId(orderItem.getProduct().getId());
        orderItemResponse.setProductName(orderItem.getProduct().getName());
        orderItemResponse.setPrice(orderItem.getPrice().getSellingPrice());
        orderItemResponse.setQuantity(orderItem.getQuantity());
        return orderItemResponse;
    }

    public List<OrderItemDto> toOrderItemList(List<OrderItem> orderItemList) {

        List<OrderItemDto> orderItemResponses = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItemResponses.add(toOrderItem(orderItem));
        }
        return orderItemResponses;
    }







}
