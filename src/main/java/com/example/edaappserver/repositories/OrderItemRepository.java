package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
Optional<OrderItem> findOrderItemById(Long id);
}
