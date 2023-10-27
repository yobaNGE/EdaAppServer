package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepositoty extends JpaRepository<Food,Integer> {

}
