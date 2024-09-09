package org.example.ordermanagement.controller.requestdto.orderitem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderItemAdditionRequestDto {


    @NotNull
    private int  productId;
    @Builder.Default
    @Min(value = 1,message = "NO Quantity less than 1")
    private int  quantity=1;
}
