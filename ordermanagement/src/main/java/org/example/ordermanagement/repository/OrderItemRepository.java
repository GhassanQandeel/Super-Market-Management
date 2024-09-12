package org.example.ordermanagement.repository;

import org.example.ordermanagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


   List<OrderItem> findByOrderId(Long orderId);

}
