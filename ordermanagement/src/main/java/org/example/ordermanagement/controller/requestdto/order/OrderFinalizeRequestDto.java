package org.example.ordermanagement.controller.requestdto.order;


import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderFinalizeRequestDto {
        @Min(1)
        private int amountPaid;

}
