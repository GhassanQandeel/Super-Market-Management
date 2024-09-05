package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.RequestDto.OrderCreationRequestDto;
import org.example.ordermanagement.controller.dto.OrderDetails;
import org.example.ordermanagement.controller.dto.OrderDto;
import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel="spring")
@Component
public abstract class OrderMapper {


    public abstract OrderDto toOrderDto(OrderDetails orderDetails);


    public Order toOrder(OrderCreationRequestDto orderCreationRequestDto){
            Order order = new Order();
            order.setCustomer(new Customer(orderCreationRequestDto.getCustomerId(), "","",""));
            order.setCashierId(orderCreationRequestDto.getCashierId());
            return order;
    };

}
