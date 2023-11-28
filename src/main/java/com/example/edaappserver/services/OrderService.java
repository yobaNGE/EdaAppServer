package com.example.edaappserver.services;

import com.example.edaappserver.repositories.FoodRepository;
import com.example.edaappserver.repositories.OrderRepository;
import com.example.edaappserver.repositories.UserRepository;
import com.example.edaappserver.requests.AddOrderRequest;
import com.example.edaappserver.responses.GetOrderResponse;
import com.example.edaappserver.restaurant.MenuItemEntity;
import com.example.edaappserver.restaurant.OrderEntity;
import com.example.edaappserver.restaurant.OrderItemEntity;
import com.example.edaappserver.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(user);

        // Создаем элементы заказа с использованием IntStream.range
        List<OrderItemEntity> orderItemEntities = IntStream.range(0, foodIds.size())
                .mapToObj(i -> {
                    MenuItemEntity menuItemEntity = foodRepository.findFoodById(foodIds.get(i))
                            .orElseThrow(() -> new RuntimeException("Food not found"));

                    OrderItemEntity orderItemEntity = new OrderItemEntity();
                    orderItemEntity.setMenuItemEntity(menuItemEntity);
                    orderItemEntity.setQuantity(foodQuantities.get(i));
                    orderItemEntity.setOrderEntity(orderEntity);

                    return orderItemEntity;
                })
                .collect(Collectors.toList());

        //order.setOrderItems(orderItems);
        orderEntity.setOrderItemEntityList(orderItemEntities);
        // Сохраняем заказ
        orderRepository.save(orderEntity);
        return "order.toString()";
    }

    public GetOrderResponse getOrder(Long id) {
        Optional<OrderEntity> orderEntity = orderRepository.findOrderById(id);

        return GetOrderResponse.builder()
                .id(orderEntity.get().getId())
                .status(orderEntity.get().getStatus())
                .orderItemEntityList(orderEntity.get().getOrderItemEntityList())
                .user(orderEntity.get().getUser())
                .build();
    }

    public String cancelOrder(long id) {
        var order = orderRepository.findOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!order.getUser().getEmail().equals(authentication.getName()))
            return "Вы не можете отменить чужой заказ";

        if (order.getStatus() != 3){
            order.setStatus(3);
            orderRepository.save(order);
            return "Заказ отменён";
        }
        else {
            return "Заказ уже отменён";
        }

    }
}
