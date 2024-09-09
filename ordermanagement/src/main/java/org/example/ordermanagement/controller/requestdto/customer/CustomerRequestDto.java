package org.example.ordermanagement.controller.requestdto.customer;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerRequestDto {
    private String name;
    private String phone;
    private String city;
}
