package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderById(Long id);
    }