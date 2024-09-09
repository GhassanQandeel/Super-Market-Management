package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.dto.orderitem.OrderItemDto;
import org.example.ordermanagement.controller.requestdto.orderitem.OrderItemAdditionRequestDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.orderitem.OrderItemOrderNotFoundException;
import org.example.ordermanagement.exception.orderitem.OrderItemPriceNotFoundException;
import org.example.ordermanagement.exception.orderitem.OrderItemProductNotFoundException;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.model.Product;
import org.example.ordermanagement.service.OrderService;
import org.example.ordermanagement.service.PriceService;
import org.example.ordermanagement.service.ProductService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
            throw new OrderItemOrderNotFoundException("Order ID for this order not found", Code.ORDER_NOT_FOUND_FOR_THIS_ORDER_ITEM, id);
        if(!productService.getProductIds().contains((long)requestDto.getProductId()))
            throw new OrderItemProductNotFoundException("Product ID for this order not found", Code.PRODUCT_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);
        //check Price if exist
        //and get product price
        if(!priceService.getPriceIds().contains(productService.getProductPrice((long)requestDto.getProductId())))
            throw new OrderItemPriceNotFoundException("Order Price For this Product Or orderITem is not found ",Code.PRICE_NOT_FOUND_FOR_THIS_ORDER_ITEM,id);



        orderItem.setOrder(orderService.getOrderById(id));
        orderItem.setProduct(productService.getProductById((long)requestDto.getProductId()));
        orderItem.setPrice(priceService.getPrice(orderItem.getProduct().getPrice().getId()));
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
