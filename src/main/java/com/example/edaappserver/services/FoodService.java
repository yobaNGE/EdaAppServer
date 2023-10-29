package com.example.edaappserver.services;

import com.example.edaappserver.repositories.FoodRepositoty;
import com.example.edaappserver.requests.AddFoodRequest;
import com.example.edaappserver.requests.DeleteFoodRequest;
import com.example.edaappserver.requests.EditFoodRequest;
import com.example.edaappserver.restaurant.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepositoty foodRepositoty;

    public List<Food> getFood() {
        return foodRepositoty.findAll();
    }

    // todo тоже хуйня, переделать нормально
    public String addFood(AddFoodRequest addFoodRequest) {
        //    private int quantity;
        //    private double price;
        //    private String name;
        //    private String pictureUrl;
        var food = Food.builder()
                .quantity(addFoodRequest.getQuantity())
                .price(addFoodRequest.getPrice())
                .name(addFoodRequest.getName())
                .build();

        foodRepositoty.save(food);
        return "походу проконало, ахуеть";
    }

    public String deleteFood(DeleteFoodRequest addFoodRequest) {
        //    private int id;

        foodRepositoty.deleteById(addFoodRequest.getId());
        return "походу удалило, ахуеть";
    }

    public String editFood(EditFoodRequest request) {
        //private int id;
        //    private int quantity;
        //    private double price;
        //    private String name;
        var food = Food.builder()
                .id(request.getId())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .name(request.getName()).build();
        foodRepositoty.save(food);
        return "калич";
    }
}
