package org.example.ordermanagement.service;


import org.example.ordermanagement.exception.customer.CustomerNotFoundException;

import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found", Code.CUSTOMER_NOT_FOUND);
        }
       return customer.get();
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public List<Long> getCustomerIds() {
        List<Long> customerIds = new ArrayList<>();
        customerRepository.findAll().stream().forEach(customer -> customerIds.add(customer.getId()));
        return customerIds;
    }
}
