package org.example.ordermanagement.controller;


import jakarta.validation.Valid;
import org.example.ordermanagement.controller.RequestDto.OrderCreationRequestDto;
import org.example.ordermanagement.controller.RequestDto.OrderItemAdditionRequestDto;
import org.example.ordermanagement.controller.dto.OrderDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.orderexceptionhandler.OrderCreationRequestNullExceptionHandler;
import org.example.ordermanagement.mapper.OrderItemMapper;
import org.example.ordermanagement.mapper.OrderMapper;
import org.example.ordermanagement.service.OrderItemService;
import org.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Fix behaviour

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id ) {
        return orderMapper.toOrderDto(orderService.getOrderById(id));
    }
    // Create Order
    @PostMapping
    public Long CreateOrder(@Valid OrderCreationRequestDto orderCreationRequestDto) {
        if (Objects.isNull(orderCreationRequestDto))
            throw new OrderCreationRequestNullExceptionHandler("The creation Request is null", Code.CREATION_ORDER_NULL);


        return orderService.createOrder(orderMapper.toOrder(orderCreationRequestDto));
    }

    @PostMapping("/{id}/order-items") // always plural
    public void addOrderItem(@PathVariable Long id, @Valid OrderItemAdditionRequestDto orderItemAdditionRequestDto) {



    }


}
