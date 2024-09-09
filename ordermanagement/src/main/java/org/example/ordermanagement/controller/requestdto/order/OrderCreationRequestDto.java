package org.example.ordermanagement.controller.requestdto.order;

import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreationRequestDto {

    @Positive(message = "cashier id is necessary to produce the order")
    private int cashierId;
    @Builder.Default
    private long customerId=0;
}
