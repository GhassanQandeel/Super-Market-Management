package org.example.ordermanagement.controller.dto;

import lombok.*;
import org.example.ordermanagement.model.Status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {

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



}
