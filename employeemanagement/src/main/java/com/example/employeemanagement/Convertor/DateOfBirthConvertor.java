package com.example.employeemanagement.Convertor;

import com.example.employeemanagement.model.Employee;

import java.sql.Date;
import java.time.LocalDate;

public class DateOfBirthConvertor {

    public static Integer convertDateOfBirth(Date dateOfBirth) {

        if (dateOfBirth == null) {
            throw  new RuntimeException("DateOfBirth is null");
        }
        else{
             Date date = Date.valueOf(LocalDate.now());
            Date date2 = dateOfBirth;

            Date date3 = new Date(date.getYear(), date.getMonth(), date.getDate());
            Date date4 = new Date(date2.getYear(), date2.getMonth(), date2.getDate());

            LocalDate date5 = date3.toLocalDate();
            LocalDate date6 = date4.toLocalDate();

            LocalDate date7 = date5.minusYears(date6.getYear());
            return date7.getYear();

        }
    }
}
