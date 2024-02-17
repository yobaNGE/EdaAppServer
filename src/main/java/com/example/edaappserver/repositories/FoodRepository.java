package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.CategoryEntity;
import com.example.edaappserver.restaurant.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<MenuItemEntity,Integer> {
    @Override
    void deleteById(Integer integer);

    @Override
    List<MenuItemEntity> findAll();

    Optional<MenuItemEntity> findFoodByName(String name);
    Optional<MenuItemEntity> findFoodById(long id);
    List<MenuItemEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);
}
