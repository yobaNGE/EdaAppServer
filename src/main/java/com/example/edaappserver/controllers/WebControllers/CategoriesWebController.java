package com.example.edaappserver.controllers.WebControllers;

import com.example.edaappserver.requests.AddCategoryRequest;
import com.example.edaappserver.restaurant.CategoryEntity;
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
@RequestMapping(path = "categories/")
public class CategoriesWebController {
    private final OrderService orderService;
    private final FoodService foodService;

    @GetMapping("/page")
    public String categoriesPage(Model model){
        model.addAttribute("categories", orderService.getCategories());
        return "categories";
    }

    @GetMapping("/{id}")
    public String categoryInfo(@PathVariable int id, Model model){
        CategoryEntity categoryEntity = orderService.getCategoryById(id);
        model.addAttribute("category", categoryEntity);
        model.addAttribute("products", foodService.getFoodByCategory(categoryEntity));
        return "category-info";
    }

    @PostMapping("/create")
    public String createCategory(AddCategoryRequest addCategoryRequest) {
        orderService.addCategory(addCategoryRequest);
        return "redirect:/categories/page";
    }
}
