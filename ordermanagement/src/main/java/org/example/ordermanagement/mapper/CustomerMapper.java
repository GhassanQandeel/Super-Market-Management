package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.dto.customer.CustomerDto;
import org.example.ordermanagement.controller.requestdto.customer.CustomerRequestDto;
import org.example.ordermanagement.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
@Component
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDto(List<Customer> customers);
    Customer toEntity(CustomerRequestDto customerRequestDto);

}
