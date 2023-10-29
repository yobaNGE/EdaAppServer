package com.example.edaappserver.controllers;

import com.example.edaappserver.requests.AddFoodRequest;
import com.example.edaappserver.requests.DeleteFoodRequest;
import com.example.edaappserver.requests.EditFoodRequest;
import com.example.edaappserver.restaurant.Food;
import com.example.edaappserver.services.FoodService;
import com.example.edaappserver.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/restaurant/food")
public class FoodController {
    private final FoodService foodService;
@Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/getFood")
    public List<Food> getFood(){
        return foodService.getFood();
    }

    // todo добавка еды хуйня, переделать (пиздеж, логику доделать блять я калоед, у меня ник в радуге KALOED) черничка
    @PostMapping("/admin/addFood")
    public String addFood(@RequestBody AddFoodRequest request){
    return foodService.addFood(request);
    }


    @PostMapping("/admin/deleteFood")
    public String addFood(@RequestBody DeleteFoodRequest request){
        return foodService.deleteFood(request);
    }

    @PostMapping("/admin/editFood")
    public String editFood(@RequestBody EditFoodRequest request){
        return foodService.editFood(request);
    }
}
