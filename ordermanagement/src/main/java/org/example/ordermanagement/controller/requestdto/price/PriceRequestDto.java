package org.example.ordermanagement.controller.requestdto.price;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PriceRequestDto {

    private int sellingPrice;
    private int buyingPrice;
}
