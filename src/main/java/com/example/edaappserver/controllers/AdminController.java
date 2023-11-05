package com.example.edaappserver.controllers;

import com.example.edaappserver.repositories.FoodRepositoty;
import com.example.edaappserver.requests.AddFoodRequest;
import com.example.edaappserver.requests.DeleteFoodRequest;
import com.example.edaappserver.requests.EditFoodRequest;
import com.example.edaappserver.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final FoodService foodService;
    @PostMapping ("/addFood")
    public String addFood(@RequestBody AddFoodRequest request){
        return foodService.addFood(request);
    }

    @DeleteMapping("/deleteFood")
    public String addFood(@RequestBody DeleteFoodRequest request){
        return foodService.deleteFood(request);
    }

    @PutMapping("/editFood")
    public String editFood(@RequestBody EditFoodRequest request){
        return foodService.editFood(request);
    }

}
