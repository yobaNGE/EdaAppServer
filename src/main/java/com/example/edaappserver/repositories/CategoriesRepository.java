package com.example.edaappserver.repositories;

import com.example.edaappserver.restaurant.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findCategoryById(int id);

}
