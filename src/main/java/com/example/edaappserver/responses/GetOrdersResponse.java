package com.example.edaappserver.responses;

import com.example.edaappserver.restaurant.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrdersResponse {
    private int id;
    private int price;
    List<OrderItemEntity> orderItems;
    int userId;
    int UserName;
    public class OrderItem{
        private int id;
        private int quantity;
        private String name;

    }
}
