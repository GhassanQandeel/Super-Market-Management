package org.example.ordermanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Insert customer name  ")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Insert customer phone number ")
    @Column(name = "phone")
    private String phone;
    @NotBlank(message = "Insert customer city ")
    private String city;
}
