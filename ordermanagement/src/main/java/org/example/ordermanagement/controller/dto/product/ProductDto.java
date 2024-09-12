package org.example.ordermanagement.controller.dto.product;


import lombok.*;
import org.example.ordermanagement.controller.dto.price.PriceDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private PriceDto price;
}
