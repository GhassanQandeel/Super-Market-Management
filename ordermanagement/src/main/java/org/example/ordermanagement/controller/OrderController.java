package org.example.ordermanagement.controller;


import jakarta.validation.Valid;
import org.example.ordermanagement.controller.requestdto.order.OrderCreationRequestDto;
import org.example.ordermanagement.controller.requestdto.order.OrderFinalizeRequestDto;
import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.controller.dto.order.OrderDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.order.OrderCreationRequestNullException;
import org.example.ordermanagement.exception.order.OrderCustomerNotFoundException;
import org.example.ordermanagement.exception.order.OrderFinalizeNullException;
import org.example.ordermanagement.exception.orderitem.OrderItemAdditionNullRequestException;
import org.example.ordermanagement.exception.orderitem.OrderItemOrderNotFoundException;
import org.example.ordermanagement.exception.orderitem.OrderItemPriceNotFoundException;
import org.example.ordermanagement.exception.orderitem.OrderItemProductNotFoundException;
import org.example.ordermanagement.mapper.OrderItemMapper;
import org.example.ordermanagement.mapper.OrderMapper;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private PriceService priceService;
    @Autowired
    private OrderItemMapper orderItemMapper;

    private final WebClient client= WebClient
            .builder()
            .baseUrl("http://localhost:6060/orders")
            .build();



    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        return orderMapper.toOrderDto(order);

    }

    @PostMapping
    public OrderDto CreateOrder(@Valid OrderCreationRequestDto orderCreationRequestDto) {


        if (Objects.isNull(orderCreationRequestDto))
            throw new OrderCreationRequestNullException("The creation Request is null", Code.CREATION_ORDER_NULL);
        if (!(customerService.getCustomerIds().contains(orderCreationRequestDto.getCustomerId())))
            throw new OrderCustomerNotFoundException("Customer  of this order ID" + orderCreationRequestDto.getCustomerId() + " not found", Code.CUSTOMER_NOT_FOUND);


        Order order = orderMapper.toOrder(orderCreationRequestDto);
        order = orderService.createOrder(order);

        return orderMapper.toOrderDto(order);

    }


    @PostMapping("/{id}/order-items")
    public OrderDto addOrderItem(@PathVariable Long id, @Valid OrderItemAdditionRequestDto orderItemAdditionRequestDto) {

        if (Objects.isNull(orderItemAdditionRequestDto))
            throw new OrderItemAdditionNullRequestException("This order Item addition is null ", Code.ORDER_ITEM_ADDITION_NULL, id);
        if(!orderService.getOrderIds().contains(id))
            throw new OrderItemOrderNotFoundException("Order ID for this order not found", Code.ORDER_NOT_FOUND_FOR_THIS_ORDER_ITEM, id);
        if(!productService.getProductIds().contains((long)orderItemAdditionRequestDto.getProductId()))
            throw new OrderItemProductNotFoundException("Product ID for this order not found", Code.PRODUCT_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);
        if(!priceService.getPriceIds().contains(productService.getProductPrice((long)orderItemAdditionRequestDto.getProductId())))
            throw new OrderItemPriceNotFoundException("Order Price For this Product Or orderITem is not found ",Code.PRICE_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);

        OrderItem orderItem = orderItemMapper.toOrderItem(id,orderItemAdditionRequestDto);
        Order order = orderItemService.addOrderItem(orderItem);
        return orderMapper.toOrderDto(order);
    }



    @PostMapping("/{id}/order-items/finalize")
    public OrderDto finalizeOrder(@PathVariable Long id, @Valid OrderFinalizeRequestDto orderFinalizeRequestDto) {

        if (Objects.isNull(orderFinalizeRequestDto))
            throw new OrderFinalizeNullException("The final request is null ->> please enter require data to final your order ", Code.ORDER_FINALIZATION_NULL, id);

         Order order = orderService.finalizeOrder(id, orderFinalizeRequestDto);
        return orderMapper.toOrderDto(order);
    }

    ///////////////////////////////////////////////////////////////





}
