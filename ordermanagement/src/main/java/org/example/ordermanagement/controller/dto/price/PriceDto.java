package org.example.ordermanagement.controller.dto.price;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PriceDto {

    private Long id;
    private int sellingPrice;
    private int buyingPrice;

}
