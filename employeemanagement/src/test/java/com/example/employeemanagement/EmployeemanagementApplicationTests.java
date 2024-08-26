package com.example.employeemanagement;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.List;

@SpringBootTest
class EmployeemanagementApplicationTests {
     @Autowired
     EmployeeRepository employeeRepository;
    @Test
    void contextLoads() {
        List<Employee> employees = employeeRepository.findAll();


        employees.stream().forEach(employee -> {
            Date date = Date.valueOf(LocalDate.now());
            Date date2 = employee.getDateOfBirth();

            Date date3 = new Date(date.getYear(), date.getMonth(), date.getDate());
            Date date4 = new Date(date2.getYear(), date2.getMonth(), date2.getDate());

            LocalDate date5 = date3.toLocalDate();
            LocalDate date6 = date4.toLocalDate();

            LocalDate date7 = date5.minusYears(date6.getYear());
            Integer age = date7.getYear();
        });


    }

}
