package com.example.employeemanagement.controller.request;

import com.example.employeemanagement.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Data
@Getter
@Setter
@ToString
public class CreatedEmployeeRequest {
    //private Long id;
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
