package com.example.employeemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(name = "name", nullable = false)
     private String name;

     @Column(name = "email", nullable = false)
     @Email
     private String email;

     @Column(name = "date_of_birth", nullable = false)
     private Date dateOfBirth;

     @Column(name = "created_date")
     private Date createdDate;

     @Column(name = "start_date")
     private Date startDate;

     @Column(name = "deploye_date")
     private Date deployeDate;

     @Enumerated(EnumType.STRING)
     @Column(name = "employee_role", nullable = false)
     private Role employeeRole;
}
