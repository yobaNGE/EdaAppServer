package com.example.edaappserver.controllers;

import com.example.edaappserver.restaurant.Food;
import com.example.edaappserver.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/restaurant")
public class FoodController {
    private final FoodService foodService;
@Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getFood(){
        return foodService.getFood();
    }
}
