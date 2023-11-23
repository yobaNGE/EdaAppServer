package com.example.edaappserver.services;

import com.example.edaappserver.repositories.FoodRepository;
import com.example.edaappserver.repositories.OrderItemRepository;
import com.example.edaappserver.repositories.OrderRepository;
import com.example.edaappserver.repositories.UserRepository;
import com.example.edaappserver.requests.AddOrderRequest;
import com.example.edaappserver.responses.AddOrderResponse;
import com.example.edaappserver.restaurant.Food;
import com.example.edaappserver.restaurant.Order;
import com.example.edaappserver.restaurant.OrderItem;
import com.example.edaappserver.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final UserRepository userRepository;
    public String createOrder(AddOrderRequest addOrderRequest) {

        // Получаем списки foodIds и foodQuantities
        List<Long> foodIds = Arrays.stream(addOrderRequest.getFoodIds().split(";"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        List<Integer> foodQuantities = Arrays.stream(addOrderRequest.getFoodQantities().split(";"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Получаем пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found " + authentication.getName())));

        // Создаем заказ и сохраняем его
        Order order = new Order();
        order.setUser(user);

        // Создаем элементы заказа с использованием IntStream.range
        List<OrderItem> orderItems = IntStream.range(0, foodIds.size())
                .mapToObj(i -> {
                    Food food = foodRepository.findFoodById(foodIds.get(i))
                            .orElseThrow(() -> new RuntimeException("Food not found"));

                    OrderItem orderItem = new OrderItem();
                    orderItem.setFood(food);
                    orderItem.setQuantity(foodQuantities.get(i));
                    orderItem.setOrder(order);

                    return orderItem;
                })
                .collect(Collectors.toList());

        //order.setOrderItems(orderItems);
        order.setOrderItemListList(orderItems);
        // Сохраняем заказ
        orderRepository.save(order);
        return "order.toString()";
    }

    public String getOrder(Long id) {
        Order order = orderRepository.findOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
            String s = "";
            for(OrderItem j :order.getOrderItemListList()){
                s += "OrderItem id: " + j.getId() + " Quantity: " + j.getQuantity() + "\n";
                s += "OrderItem foodName: " + j.getFood().getName() + " Price: " + j.getFood().getPrice() + "\n";
            }
        return s;
    }
}
