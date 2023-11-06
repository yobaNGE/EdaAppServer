package com.example.edaappserver.controllers;

import com.example.edaappserver.repositories.FoodRepositoty;
import com.example.edaappserver.restaurant.Food;
import com.example.edaappserver.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff/")
@RequiredArgsConstructor
public class StaffController {
    private final FoodService foodService;
    @GetMapping("/getFood")
    public List<Food> getFood(){
        return foodService.getFood();
    }

}