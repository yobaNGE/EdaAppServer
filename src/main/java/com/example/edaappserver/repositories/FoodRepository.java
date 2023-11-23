package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    @Override
    void deleteById(Integer integer);

    @Override
    List<Food> findAll();

    Optional<Food> findFoodByName(String name);
    Optional<Food> findFoodById(long id);
}
