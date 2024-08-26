package com.example.employeemanagement.controller.request;

import com.example.employeemanagement.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.sql.Date;

@Data
@Getter
@Setter
@ToString

@ValidateOnExecution
public class CreatedEmployeeRequest {
//     private Long id;

     @NotBlank(message = "Name should not be empty")

     private String name;
     @NotBlank(message = "Email should not be empty")
     @Email
     private String email;
     @NotNull(message = "you should put your Date of birth")
     private Date dateOfBirth;
     private Date createdDate;
     private Date startDate;
     private Date deployeDate;
     @Enumerated(EnumType.STRING)
     private Role employeeRole;

}
