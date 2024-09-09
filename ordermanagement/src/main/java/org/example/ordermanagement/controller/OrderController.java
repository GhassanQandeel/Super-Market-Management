package org.example.ordermanagement.controller;


import jakarta.validation.Valid;
import org.example.ordermanagement.controller.requestdto.order.OrderCreationRequestDto;
import org.example.ordermanagement.controller.requestdto.order.OrderFinalizeRequestDto;
import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.controller.dto.order.FinalizeOrderDto;
import org.example.ordermanagement.controller.dto.order.OrderDto;
import org.example.ordermanagement.controller.dto.orderitem.OrderItemResponse;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderCreationRequestNullException;
import org.example.ordermanagement.exception.order.OrderFinalizeNullException;
import org.example.ordermanagement.exception.orderitem.OrderItemAdditionNullRequestException;
import org.example.ordermanagement.mapper.OrderItemMapper;
import org.example.ordermanagement.mapper.OrderMapper;
import org.example.ordermanagement.service.OrderItemService;
import org.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public OrderDto getOrderById(@PathVariable Long id ) {
        return orderMapper.toOrderDto(orderService.getOrderById(id));
    }

    @GetMapping("/{id}/order-items")
    public List<OrderItemResponse> getOrderItemsByOrderId(@PathVariable Long id ) {
        return orderMapper.toOrderItemList(orderItemService.getOrderItemsByOrderId(id));
    }


    // step 1: Create Order
    @PostMapping
    public Long CreateOrder(@Valid OrderCreationRequestDto orderCreationRequestDto) {
        if (Objects.isNull(orderCreationRequestDto))
            throw new OrderCreationRequestNullException("The creation Request is null", Code.CREATION_ORDER_NULL);

        return orderService.createOrder(orderMapper.toOrder(orderCreationRequestDto));
    }

    // step 2: add Products.
    @PostMapping("/{id}/order-items")
    public void addOrderItem(@PathVariable Long id, @Valid OrderItemAdditionRequestDto orderItemAdditionRequestDto) {
        if(Objects.isNull(orderItemAdditionRequestDto))
            throw new OrderItemAdditionNullRequestException("This order Item addition is null ",Code.ORDER_ITEM_ADDITION_NULL,id);

        orderItemService.addOrderItem(orderItemMapper.toOrderItem(id,orderItemAdditionRequestDto));
    }

    // step 3: get total price
    @GetMapping("/{id}/order-items/total-price")
    public String getOrderItemTotalPrice(@PathVariable Long id ) {
       return orderItemService.getOrderItemTotalPrice(id);

    }


    // step 4: close the order.
    @PostMapping("/{id}/order-items/finalize")
    public FinalizeOrderDto finalizeOrder(@PathVariable Long id, @Valid OrderFinalizeRequestDto orderFinalizeRequestDto){
        if (Objects.isNull(orderFinalizeRequestDto))
            throw new OrderFinalizeNullException("The final request is null ->> please enter require data to final your order ",Code.ORDER_FINALIZATION_NULL,id);
        return orderMapper.toFinalizeOrderDto(orderService.finalizeOrder(id,orderFinalizeRequestDto));
    }




}
