package org.example.ordermanagement.repository;

import org.example.ordermanagement.model.Order;

import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.projections.OrderItemProjections;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true,
            value =
                """
                        SELECT oi
                        FROM order_item oi left join price pc on oi.price_id = pc.id
                        LEFT JOIN product pr on oi.product_id = pr.id
                        WHERE order_id=:orderId;

""")
    List<OrderItem> findOrderItemByOrderId(Long orderId);




}
