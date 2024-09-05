package org.example.ordermanagement.controller.RequestDto;

import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreationRequestDto {

    @Positive(message = "cashier id is necessary to produce the order")
    private int cashierId;

    private long customerId;
}
