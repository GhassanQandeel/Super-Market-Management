package org.example.ordermanagement.controller;

import org.example.ordermanagement.controller.dto.customer.CustomerDto;
import org.example.ordermanagement.controller.requestdto.customer.CustomerRequestDto;
import org.example.ordermanagement.exception.customer.CustomerRequestNullExceptionHandler;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.mapper.CustomerMapper;
import org.example.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerMapper.toDto(customerService.getCustomers());
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {

        if (Objects.isNull(customerRequestDto))
            throw new CustomerRequestNullExceptionHandler("Customer Request is null", Code.CUSTOMER_REQUEST_NULL);

        customerService.createCustomer(customerMapper.toEntity(customerRequestDto));
    }


}
