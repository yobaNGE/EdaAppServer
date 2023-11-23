package com.example.edaappserver.controllers;

import com.example.edaappserver.requests.AddOrderRequest;
import com.example.edaappserver.responses.AddOrderResponse;
import com.example.edaappserver.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
//    @PostMapping("/addOrder")
//    public ResponseEntity<AddOrderResponse> addOrder(
//            @RequestBody AddOrderRequest addOrderRequest
//    ){
//        return ResponseEntity.ok(orderService.placeOrder(addOrderRequest));
//    }

    @PostMapping("/addOrder")
    public String addOrder(
            @RequestBody AddOrderRequest addOrderRequest
    ){
        return orderService.createOrder(addOrderRequest);
    }
    @GetMapping("/getOrder/{id}")
    public String getOrder(
            @PathVariable("id") Long id
    ){
        return orderService.getOrder(id);
    }
}
