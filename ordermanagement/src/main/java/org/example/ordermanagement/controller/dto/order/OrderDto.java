package org.example.ordermanagement.controller.dto.order;


import lombok.*;
import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.model.Status;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {

     private Long id;

    private LocalDateTime createdAt;

    private int cashierId;

    private int amountPaid;

    private Status status;

    private Customer customer;

}
