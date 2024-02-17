package com.example.edaappserver.controllers.WebControllers;

import com.example.edaappserver.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "orders/")
public class OrdersWebController {

    private final OrderService orderService;

    @GetMapping("/page")
    public String ordersPage(Model model){
        model.addAttribute("ordersList", orderService.getOrders());
        return "orders";
    }
}
