package org.example.ordermanagement.service;

import org.example.ordermanagement.model.Customer;
import org.example.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
