package com.example.employeemanagement.specification.dto;

import com.example.employeemanagement.model.Role;
import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeSearch {
    
     private Long id;
     private String name;
     private String email;
     private Date dateOfBirth;
     private Date createdDate;
     private Date startDate;
     private Date deployeDate;
     private Role employeeRole;

}
