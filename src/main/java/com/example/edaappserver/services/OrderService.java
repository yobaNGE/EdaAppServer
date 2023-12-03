package com.example.edaappserver.services;

import com.example.edaappserver.repositories.CategoriesRepository;
import com.example.edaappserver.repositories.FoodRepository;
import com.example.edaappserver.repositories.OrderRepository;
import com.example.edaappserver.repositories.UserRepository;
import com.example.edaappserver.requests.AddCategoryRequest;
import com.example.edaappserver.requests.AddOrderRequest;
import com.example.edaappserver.responses.GetOrderResponse;
import com.example.edaappserver.responses.GetOrdersResponse;
import com.example.edaappserver.restaurant.CategoryEntity;
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
    private final CategoriesRepository categoriesRepository;

    /**
 * Метод для создания заказа.
 *
 * @param addOrderRequest Объект запроса, содержащий информацию о заказе.
 * @return Строковое представление созданного заказа.
 */
public String createOrder(AddOrderRequest addOrderRequest) {

    // Получаем списки foodIds и foodQuantities из запроса, преобразуя их в списки Long и Integer соответственно.
    List<Long> foodIds = Arrays.stream(addOrderRequest.getFoodIds().split(";"))
            .map(Long::parseLong)
            .collect(Collectors.toList());

    List<Integer> foodQuantities = Arrays.stream(addOrderRequest.getFoodQantities().split(";"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    // Получаем текущего аутентифицированного пользователя.
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserEntity user = (userRepository.findByEmail(authentication.getName())
            .orElseThrow(() -> new RuntimeException("User not found " + authentication.getName())));

    // Создаем новый объект заказа и устанавливаем для него пользователя.
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setUser(user);

    // Создаем элементы заказа, используя списки foodIds и foodQuantities.
    // Для каждого элемента заказа находим соответствующий пункт меню и устанавливаем количество.
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

    // Устанавливаем список элементов заказа для объекта заказа.
    orderEntity.setOrderItemEntityList(orderItemEntities);

    // Сохраняем заказ в репозитории.
    orderRepository.save(orderEntity);

    // Возвращаем строковое представление заказа.
    return "order.toString()";
}

    /**
 * Метод для получения информации о заказе по его идентификатору.
 *
 * @param id Идентификатор заказа.
 * @return Объект GetOrderResponse, содержащий информацию о заказе.
 */
public GetOrderResponse getOrder(Long id) {
    // Ищем заказ в репозитории по идентификатору.
    Optional<OrderEntity> orderEntity = orderRepository.findOrderById(id);

    // Строим и возвращаем ответ, содержащий информацию о заказе.
    return GetOrderResponse.builder()
            .id(orderEntity.get().getId()) // Устанавливаем идентификатор заказа.
            .status(orderEntity.get().getStatus()) // Устанавливаем статус заказа.
            .orderItemEntityList(orderEntity.get().getOrderItemEntityList()) // Устанавливаем список элементов заказа.
            .user(orderEntity.get().getUser()) // Устанавливаем пользователя, сделавшего заказ.
            .build(); // Строим и возвращаем объект ответа.
}

    /**
 * Метод для отмены заказа.
 *
 * @param id Идентификатор заказа.
 * @return Строковое сообщение о результате операции.
 */
public String cancelOrder(long id) {
    // Ищем заказ в репозитории по идентификатору.
    var order = orderRepository.findOrderById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

    // Получаем текущего аутентифицированного пользователя.
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    // Проверяем, что пользователь, пытающийся отменить заказ, является его владельцем.
    if (!order.getUser().getEmail().equals(authentication.getName()))
        return "Вы не можете отменить чужой заказ";

    // Проверяем статус заказа. Если он еще не отменен, отменяем его и сохраняем изменения в репозитории.
    if (order.getStatus() != 3){
        order.setStatus(3);
        orderRepository.save(order);
        return "Заказ отменён";
    }
    // Если заказ уже отменен, возвращаем соответствующее сообщение.
    else {
        return "Заказ уже отменён";
    }
}

public List<CategoryEntity> getCategories() {

    List<CategoryEntity> categoryEntities = categoriesRepository.findAll();
    return categoryEntities;
}

    public String addCategory(AddCategoryRequest addCategoryRequest) {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .category(addCategoryRequest.getCategory())
                .categoryName(addCategoryRequest.getCategoryName())
                .build();

        categoriesRepository.save(categoryEntity);

        return "Категория добавлена " + categoryEntity.getId() + " " + categoryEntity.getCategoryName();

    }
    /*
    public class GetOrdersResponse {
    private int id;
    private int price;
    List<OrderItemEntity> orderItems;
    public class OrderItem{
        private int id;
        private int quantity;
        private String name;

    }
}
     */

    public List<OrderEntity> getOrders() {
    List<OrderEntity> orderEntities = orderRepository.findOrOrderByStatus(1);

    return orderEntities;


    }
}
