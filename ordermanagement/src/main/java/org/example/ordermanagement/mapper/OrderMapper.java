package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.dto.customer.CustomerDto;

import org.example.ordermanagement.controller.requestdto.order.OrderCreationRequestDto;
import org.example.ordermanagement.controller.dto.order.FinalizeOrderDto;
import org.example.ordermanagement.controller.dto.order.OrderDto;
import org.example.ordermanagement.controller.dto.orderitem.OrderItemDto;
import org.example.ordermanagement.exception.business.AmountPaidNotEnoughException;

import org.example.ordermanagement.model.*;
import org.example.ordermanagement.service.CustomerService;
import org.example.ordermanagement.service.OrderItemService;
import org.mapstruct.Mapper;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel="spring")

public abstract class OrderMapper {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderItemService orderItemService;



     public OrderDto toOrderDto(Order order){

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setStatus(order.getStatus());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setCreatedAt(order.getCreatedAt());
        orderDto.setStatus(order.getStatus());
        orderDto.setCashierId(order.getCashierId());
        orderDto.setAmountPaid(order.getAmountPaid());

            Customer customer = order.getCustomer();
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setName(customer.getName());
            customerDto.setCity(customer.getCity());
            customerDto.setPhone(customer.getPhone());

        orderDto.setCustomerDto(customerDto);

            List<OrderItem> orderItems = order.getOrderItems();
            List<OrderItemDto> orderItemDtos = new ArrayList<>();
            if (orderItems != null)
                for (OrderItem orderItem : orderItems) {
                    Product product = orderItem.getProduct();
                    Price price = orderItem.getPrice();


                    orderItemDtos.add(
                            new OrderItemDto(
                                product.getId(),
                                product.getName(),
                                price.getSellingPrice(),
                                orderItem.getQuantity()
                            )
                    );
                }

        orderDto.setOrderItemDtos(orderItemDtos);
        return orderDto;

    }


    public Order toOrder(OrderCreationRequestDto orderCreationRequestDto){
            Order order = new Order();
            Customer customer = new Customer();
            customer.setId(orderCreationRequestDto.getCustomerId());

            order.setCustomer(customer);
            order.setCashierId(orderCreationRequestDto.getCashierId());
            order.setStatus(Status.ADJUSTABLE);

            return order;
    }



    public FinalizeOrderDto toFinalizeOrderDto(Order order) {

        FinalizeOrderDto finalizeOrderDto = new FinalizeOrderDto();


        finalizeOrderDto.setStatus(order.getStatus());
        finalizeOrderDto.setAmountPaid(order.getAmountPaid());


        List<OrderItem> items =order.getOrderItems();
        int totalPrice;
        totalPrice=items.stream().mapToInt(orderItem -> (orderItem.getQuantity()*orderItem.getPrice().getSellingPrice())).sum();



        if (!(order.getAmountPaid()-totalPrice>=0))
            throw new AmountPaidNotEnoughException("The amount you paid is not enough ");

        finalizeOrderDto.setTotalPrice(totalPrice);
        finalizeOrderDto.setAmountReturn(order.getAmountPaid()-totalPrice);


        return finalizeOrderDto;
    }




}
