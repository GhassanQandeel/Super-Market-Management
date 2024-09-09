package org.example.ordermanagement.controller.dto.customer;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private Long id;
    private String name;
    private String phone;
    private String city;
}
