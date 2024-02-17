//package com.example.edaappserver.controllers;
//
//import com.example.edaappserver.requests.AddCategoryRequest;
//import com.example.edaappserver.requests.AddFoodRequest;
//import com.example.edaappserver.requests.AuthenticationRequest;
//import com.example.edaappserver.requests.DeleteFoodRequest;
//import com.example.edaappserver.responses.GetOrderResponse;
//import com.example.edaappserver.responses.GetOrdersResponse;
//import com.example.edaappserver.restaurant.CategoryEntity;
//import com.example.edaappserver.restaurant.MenuItemEntity;
//import com.example.edaappserver.restaurant.OrderItemEntity;
//import com.example.edaappserver.services.AuthenticationService;
//import com.example.edaappserver.services.FoodService;
//import com.example.edaappserver.services.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequiredArgsConstructor
//public class MainController {
//    private final FoodService foodService;
//    private final OrderService orderService;
//    private final AuthenticationService authenticationService;
//    @GetMapping("/home")
//    public String home(Model model){
//        return "home";
//    }
//
//    @GetMapping("/food/page")
//    public String foodpage(Model model){
//        model.addAttribute("food", foodService.getFood());
//        return "food";
//    }
//
//    @GetMapping("/food/{id}")
//    public String productInfo(@PathVariable int id, Model model){
//        MenuItemEntity menuItemEntity = foodService.getFoodById(id);
//        model.addAttribute("product", menuItemEntity);
//        return "food-info";
//
//    }
//
//    @PostMapping("food/create")
//    public String createProduct(AddFoodRequest addFoodRequest) {
//        foodService.addFood(addFoodRequest);
//        return "redirect:/food/page";
//    }
//
//    @PostMapping("food/delete/{id}")
//    public String deleteProduct(@PathVariable int id){
//        foodService.deleteFood(new DeleteFoodRequest(id));
//        return "redirect:/food/page";
//    }
//
//    @GetMapping("/categories/page")
//    public String categoriesPage(Model model){
//        model.addAttribute("categories", orderService.getCategories());
//        return "categories";
//    }
//
//    @GetMapping("/categories/{id}")
//    public String categoryInfo(@PathVariable int id, Model model){
//        CategoryEntity categoryEntity = orderService.getCategoryById(id);
//        model.addAttribute("category", categoryEntity);
//        model.addAttribute("products", foodService.getFoodByCategory(categoryEntity));
//        return "category-info";
//    }
//
//    @PostMapping("categories/create")
//    public String createCategory(AddCategoryRequest addCategoryRequest) {
//        orderService.addCategory(addCategoryRequest);
//        return "redirect:/categories/page";
//    }
//
//
//    @GetMapping("/orders/page")
//    public String ordersPage(Model model){
//        model.addAttribute("ordersList", orderService.getOrders());
//        return "orders";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//
//}
