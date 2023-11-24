package com.example.edaappserver.services;

import com.example.edaappserver.repositories.FoodRepository;
import com.example.edaappserver.requests.AddFoodRequest;
import com.example.edaappserver.requests.DeleteFoodRequest;
import com.example.edaappserver.requests.EditFoodRequest;
import com.example.edaappserver.restaurant.MenuItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    public List<MenuItemEntity> getFood() {
        return foodRepository.findAll();
    }


    // todo тоже хуйня, переделать нормально
    public String addFood(AddFoodRequest addFoodRequest) {
        //    private int quantity;
        //    private double price;
        //    private String name;
        //    private String pictureUrl;
        var food = MenuItemEntity.builder()
                .quantity(addFoodRequest.getQuantity())
                .price(addFoodRequest.getPrice())
                .name(addFoodRequest.getName())
                .pictureUrl(
                        "server.com/static/pictures/"
                        // todo походу проканало, но вот ощущение что хуйню сделал, по моему проще на месте адрес формировать.
                )
                .build();

        foodRepository.save(food);
        setFoodUrl(food);
        return "походу проконало, ахуеть " + food.getId();
    }

    public String setFoodUrl(MenuItemEntity menuItemEntity){
        menuItemEntity.setPictureUrl(
                menuItemEntity.getPictureUrl() + menuItemEntity.getId() + ".jpg"
        );
        foodRepository.save(menuItemEntity);
        return foodRepository.findById(menuItemEntity.getId()).toString();
    }

    public String setFoodPrice(MenuItemEntity menuItemEntity){
        menuItemEntity.setPrice(
                menuItemEntity.getPrice()
        );
        foodRepository.save(menuItemEntity);
        return foodRepository.findById(menuItemEntity.getId()).toString();
    }

    public String deleteFood(DeleteFoodRequest addFoodRequest) {
        //    private int id;

        foodRepository.deleteById(addFoodRequest.getId());
        return "походу удалило, ахуеть";
    }

    public String editFood(EditFoodRequest request) {
        //private int id;
        //    private int quantity;
        //    private double price;
        //    private String name;
        var food = MenuItemEntity.builder()
                .id(request.getId())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .name(request.getName()).build();
        foodRepository.save(food);
        return "калич";

    }


}
