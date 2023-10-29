package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepositoty extends JpaRepository<Food,Integer> {
    @Override
    void deleteById(Integer integer);

    @Override
    List<Food> findAll();
}
