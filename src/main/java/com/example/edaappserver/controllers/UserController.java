package com.example.edaappserver.controllers;

import com.example.edaappserver.restaurant.MenuItemEntity;
import com.example.edaappserver.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final FoodService foodService;
    @GetMapping("/getFood")
    public List<MenuItemEntity> getFood(){
        return foodService.getFood();
    }


}
