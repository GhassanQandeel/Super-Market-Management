package org.example.ordermanagement.repository;

import org.example.ordermanagement.model.Order;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(
            value = """
                SELECT o
                FROM Order o
                JOIN FETCH o.customer c 
                LEFT JOIN FETCH o.orderItems
                where o.id = ?1
"""
    )
    Order findOrderById(Long id);
}
