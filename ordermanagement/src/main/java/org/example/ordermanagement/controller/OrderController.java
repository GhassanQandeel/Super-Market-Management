package org.example.ordermanagement.controller;


import jakarta.validation.Valid;
import org.example.ordermanagement.controller.requestdto.order.OrderCreationRequestDto;
import org.example.ordermanagement.controller.requestdto.order.OrderFinalizeRequestDto;
import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.controller.dto.order.FinalizeOrderDto;
import org.example.ordermanagement.controller.dto.order.OrderDto;
import org.example.ordermanagement.controller.dto.orderitem.OrderItemDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderCreationRequestNullException;
import org.example.ordermanagement.exception.order.OrderFinalizeNullException;
import org.example.ordermanagement.exception.orderitem.OrderItemAdditionNullRequestException;
import org.example.ordermanagement.mapper.OrderItemMapper;
import org.example.ordermanagement.mapper.OrderMapper;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.service.OrderItemService;
import org.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;


    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        return orderMapper.toOrderDto(order);

    }

    @PostMapping
    public OrderDto CreateOrder(@Valid OrderCreationRequestDto orderCreationRequestDto) {
        if (Objects.isNull(orderCreationRequestDto))
            throw new OrderCreationRequestNullException("The creation Request is null", Code.CREATION_ORDER_NULL);

        return orderMapper.toOrderDto(
                orderService.createOrder(
                        orderMapper.toOrder(
                                orderCreationRequestDto
                        )
                )
        );

    }


    @PostMapping("/{id}/order-items")
    public OrderDto addOrderItem(@PathVariable Long id, @Valid OrderItemAdditionRequestDto orderItemAdditionRequestDto) {
        if (Objects.isNull(orderItemAdditionRequestDto))
            throw new OrderItemAdditionNullRequestException("This order Item addition is null ", Code.ORDER_ITEM_ADDITION_NULL, id);

        return orderMapper.toOrderDto(orderItemService.addOrderItem(orderItemMapper.toOrderItem(id, orderItemAdditionRequestDto)));
    }





    @PostMapping("/{id}/order-items/finalize")
    public FinalizeOrderDto finalizeOrder(@PathVariable Long id, @Valid OrderFinalizeRequestDto orderFinalizeRequestDto){
        if (Objects.isNull(orderFinalizeRequestDto))
            throw new OrderFinalizeNullException("The final request is null ->> please enter require data to final your order ",Code.ORDER_FINALIZATION_NULL,id);
        return orderMapper.toFinalizeOrderDto(orderService.finalizeOrder(id,orderFinalizeRequestDto));
    }



}
