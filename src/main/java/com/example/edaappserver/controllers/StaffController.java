package com.example.edaappserver.controllers;

import com.example.edaappserver.requests.ChangeOrderStatus;
import com.example.edaappserver.responses.GetOrdersResponse;
import com.example.edaappserver.restaurant.MenuItemEntity;
import com.example.edaappserver.restaurant.OrderEntity;
import com.example.edaappserver.services.FoodService;
import com.example.edaappserver.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff/")
@RequiredArgsConstructor
public class StaffController {
    private final FoodService foodService;
    private final OrderService orderService;
    @GetMapping("/getFood")
    public List<MenuItemEntity> getFood(){
        return foodService.getFood();
    }

    @GetMapping("/getOrders")
    public List<OrderEntity> getOrders(){
        return orderService.getOrders();
    }

    @PutMapping("/changeStatus")
    public String changeStatus(@RequestBody ChangeOrderStatus changeOrderStatus){
        return orderService.changeStatus(changeOrderStatus);
    }
}
