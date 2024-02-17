package com.example.edaappserver.controllers.WebControllers;

import com.example.edaappserver.requests.AddFoodRequest;
import com.example.edaappserver.requests.DeleteFoodRequest;
import com.example.edaappserver.restaurant.MenuItemEntity;
import com.example.edaappserver.services.FoodService;
import com.example.edaappserver.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "food")
public class FoodWebController {
    private final FoodService foodService;
    private final OrderService orderService;

    @GetMapping("/page")
    public String foodpage(Model model){
        model.addAttribute("food", foodService.getFood());
        model.addAttribute("categories", orderService.getCategories());
        return "food";
    }

    @GetMapping("/{id}")
    public String productInfo(@PathVariable int id, Model model){
        MenuItemEntity menuItemEntity = foodService.getFoodById(id);
        model.addAttribute("product", menuItemEntity);
        return "food-info";

    }

    @PostMapping("/create")
    public String createProduct(AddFoodRequest addFoodRequest) {
        foodService.addFood(addFoodRequest);
        return "redirect:/food/page";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        foodService.deleteFood(new DeleteFoodRequest(id));
        return "redirect:/food/page";
    }
}
