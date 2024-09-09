package org.example.ordermanagement.controller.requestdto.product;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequestDto {

    @NotNull
    private String name;
    @NotNull
    private Long priceId;

}
