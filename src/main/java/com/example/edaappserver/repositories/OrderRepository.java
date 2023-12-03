package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findOrderById(Long id);

    List<OrderEntity> findOrOrderByStatus(int id);
    //Optional<OrderEntity> findOrderByEmail(String email);
    }