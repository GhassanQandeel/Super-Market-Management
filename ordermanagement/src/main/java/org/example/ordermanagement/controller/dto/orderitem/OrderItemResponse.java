package org.example.ordermanagement.controller.dto.orderitem;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemResponse {
    private Long productId;
    private String productName;
    private int price;
    private int quantity;

}
