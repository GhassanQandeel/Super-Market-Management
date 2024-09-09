package org.example.ordermanagement.controller.dto.price;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
