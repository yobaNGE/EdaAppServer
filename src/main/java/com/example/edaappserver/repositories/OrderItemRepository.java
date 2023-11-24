package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer>{
Optional<OrderItemEntity> findOrderItemById(Long id);
}
