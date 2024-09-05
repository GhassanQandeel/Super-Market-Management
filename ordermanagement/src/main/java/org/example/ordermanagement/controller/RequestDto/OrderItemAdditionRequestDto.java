package org.example.ordermanagement.controller.RequestDto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderItemAdditionRequestDto {

    private int  productId;
    private int  quantity;
}
