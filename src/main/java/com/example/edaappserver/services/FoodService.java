package com.example.edaappserver.services;

import com.example.edaappserver.restaurant.Food;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    public List<Food> getFood(){
        return List.of(
                new Food(
                        1,
                        2,
                        2.0,
                        "Cock and balls",
                        "/pics/"+ 1 + ".jpg"
                )
        );
    }
}
