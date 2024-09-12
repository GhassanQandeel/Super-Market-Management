package org.example.ordermanagement.model;

import jakarta.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
@Table(name = "order_item")
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private int quantity=1;

    @ManyToOne
    @JoinColumn(name = "price_id")
    @NotNull(message = "SHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIT")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;






}
