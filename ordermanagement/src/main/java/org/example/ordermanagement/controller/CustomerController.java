package org.example.ordermanagement.controller;

import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    // Where is dtos ?
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
    @PostMapping
    // Where is dtos ?
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }






}
