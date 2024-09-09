package org.example.ordermanagement.controller.dto.product;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.ordermanagement.controller.dto.price.PriceDto;
import org.example.ordermanagement.model.Price;

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
