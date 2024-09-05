package org.example.ordermanagement.controller.dto;

import lombok.*;
import org.example.ordermanagement.model.Order;
import org.example.ordermanagement.model.Status;
import org.example.ordermanagement.projections.OrderItemProjections;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderDetails {



    private Long orderId;

    private int cashierId;

    private LocalDateTime orderDate;

    private Long customerId;
    private String customerName;
    private String customerCity;

    private Status status;

    private int amountPaid;

    private List<ProductDto> products;

    private int totalAmount;

    public OrderDetails( Order order,List<OrderItemProjections> orderItemProjections) {
         List<ProductDto> productDtoList = new ArrayList<>();


        // return all products of the order
        orderItemProjections
                .forEach(orderItemProjection -> productDtoList
                        .add(
                             new ProductDto(
                                            orderItemProjection.getId(),
                                            orderItemProjection.getName(),
                                            orderItemProjection.getSellingPrice(),
                                            orderItemProjection.getQuantity())));


        // calculate total salary
        int totalAmount = productDtoList
                .stream()
                .mapToInt(productDto -> (productDto.getPrice() * productDto.getQuantity()))
                .sum();


        this.orderId=order.getId();
        this.cashierId=order.getCashierId();
        this.orderDate=order.getCreatedAt();
        this.customerId=order.getCustomer().getId();
        this.customerName=order.getCustomer().getName();
        this.customerCity=order.getCustomer().getCity();
        this.status=order.getStatus();
        this.amountPaid=order.getAmountPaid();
        this.products=productDtoList;
        this.totalAmount=totalAmount;
    }



}
