package com.example.employeemanagement;

import com.example.employeemanagement.controller.request.CreatedEmployeeRequest;
import com.example.employeemanagement.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
class EmployeemanagementApplicationTests {
     @Autowired
     EmployeeRepository employeeRepository;
     @Autowired
     HttpServletRequest request;
    @Test
    void contextLoads() {



        CreatedEmployeeRequest createdEmployeeRequest=null;

        if (Objects.isNull(createdEmployeeRequest)) {
                System.out.println("Create Employee Request"+request.getRequestURI() );
        }






    }

}
