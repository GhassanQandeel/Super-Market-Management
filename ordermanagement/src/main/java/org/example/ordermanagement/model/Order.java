package org.example.ordermanagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "cashier_id")
    private int cashierId;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;






}
