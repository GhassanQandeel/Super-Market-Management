package org.example.ordermanagement.controller.dto.order;

import lombok.*;
import org.example.ordermanagement.model.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FinalizeOrderDto {
    private Status status;
    private int totalPrice;
    private int amountPaid;
    private int amountReturn;

}
