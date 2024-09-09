package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.requestdto.order.OrderCreationRequestDto;
import org.example.ordermanagement.controller.dto.order.FinalizeOrderDto;
import org.example.ordermanagement.controller.dto.order.OrderDto;
import org.example.ordermanagement.controller.dto.orderitem.OrderItemResponse;
import org.example.ordermanagement.exception.business.AmountPaidNotEnoughException;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderCustomerNotFound;
import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.model.Status;
import org.example.ordermanagement.service.CustomerService;
import org.example.ordermanagement.service.OrderItemService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel="spring")
@Component
public abstract class OrderMapper {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderItemService orderItemService;



    public abstract OrderDto toOrderDto(Order order);


    public Order toOrder(OrderCreationRequestDto orderCreationRequestDto){
            Order order = new Order();

            if(customerService.getCustomerIds().contains(orderCreationRequestDto.getCustomerId()))
                order.setCustomer(new Customer(orderCreationRequestDto.getCustomerId(), "","",""));
            else
                throw new OrderCustomerNotFound("Customer  of this order ID"+orderCreationRequestDto.getCustomerId()+" not found", Code.CUSTOMER_NOT_FOUND);

            order.setCashierId(orderCreationRequestDto.getCashierId());
            order.setStatus(Status.ADJUSTABLE);

            return order;
    }

    public FinalizeOrderDto toFinalizeOrderDto(Order order) {

        FinalizeOrderDto finalizeOrderDto = new FinalizeOrderDto();


        finalizeOrderDto.setStatus(order.getStatus());
        finalizeOrderDto.setAmountPaid(order.getAmountPaid());


        List<OrderItem> items =orderItemService.getOrderItemsByOrderId(order.getId());
        int totalPrice;
        totalPrice=items.stream().mapToInt(orderItem -> (orderItem.getQuantity()*orderItem.getPrice().getSellingPrice())).sum();


        finalizeOrderDto.setTotalPrice(totalPrice);
        if (!(order.getAmountPaid()-totalPrice>=0))
            throw new AmountPaidNotEnoughException("The amount you paid is not enough ");

        finalizeOrderDto.setAmountReturn(order.getAmountPaid()-totalPrice);


        return finalizeOrderDto;
    }




    public OrderItemResponse toOrderItem(OrderItem orderItem) {
        OrderItemResponse orderItemResponse = new OrderItemResponse();

        orderItemResponse.setProductId(orderItem.getProduct().getId());
        orderItemResponse.setProductName(orderItem.getProduct().getName());
        orderItemResponse.setPrice(orderItem.getPrice().getSellingPrice());
        orderItemResponse.setQuantity(orderItem.getQuantity());
        return orderItemResponse;
    }

    public List<OrderItemResponse> toOrderItemList(List<OrderItem> orderItemList) {

        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItemResponses.add(toOrderItem(orderItem));
        }
        return orderItemResponses;
    }
}
