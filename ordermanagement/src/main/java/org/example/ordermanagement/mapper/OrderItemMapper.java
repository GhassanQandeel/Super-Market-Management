package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.orderitem.OrderItemOrderNotFound;
import org.example.ordermanagement.exception.orderitem.OrderItemPriceNotFound;
import org.example.ordermanagement.exception.orderitem.OrderItemProductNotFound;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.model.Product;
import org.example.ordermanagement.service.OrderService;
import org.example.ordermanagement.service.PriceService;
import org.example.ordermanagement.service.ProductService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel="spring")
abstract public class OrderItemMapper {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PriceService priceService;

    public OrderItem toOrderItem(Long id ,OrderItemAdditionRequestDto requestDto){
        OrderItem orderItem = new OrderItem();


        if(!orderService.getOrderIds().contains(id))
            throw new OrderItemOrderNotFound("Order ID for this order not found", Code.ORDER_NOT_FOUND_FOR_THIS_ORDER_ITEM, id);
        if(!productService.getProductIds().contains((long)requestDto.getProductId()))
            throw new OrderItemProductNotFound("Product ID for this order not found", Code.PRODUCT_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);
        //check Price if exist
        //and get product price
        if(!priceService.getPriceIds().contains(productService.getProductPrice((long)requestDto.getProductId())))
            throw new OrderItemPriceNotFound("Order Price For this Product Or orderITem is not found ",Code.PRICE_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);



        orderItem.setOrder(new Order(id,null,0,0,null,null));
        orderItem.setProduct(new Product((long) requestDto.getProductId(), "",null));
        orderItem.setPrice(new Price(productService.getProductPrice(orderItem.getProduct().getId()),0,0));
        orderItem.setQuantity(requestDto.getQuantity());

        return orderItem;

    }






}
