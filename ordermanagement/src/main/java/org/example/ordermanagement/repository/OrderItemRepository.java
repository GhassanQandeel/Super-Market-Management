package org.example.ordermanagement.repository;

import org.example.ordermanagement.model.OrderItem;
import org.example.ordermanagement.projections.OrderItemsProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    @Query(nativeQuery = true,
            value =
                """
                        SELECT pr.id,pr.name,pc.selling_price,oi.quantity
                        FROM order_item oi left join price pc on oi.price_id = pc.id
                        LEFT JOIN product pr on oi.product_id = pr.id
                        WHERE order_id=:orderId;

""")
    List<OrderItemsProjections> findByOrderId(Long orderId);
}
