package org.example.ordermanagement.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {

    private Long id;
    private String name;
    private int price;
    private int quantity;
}
