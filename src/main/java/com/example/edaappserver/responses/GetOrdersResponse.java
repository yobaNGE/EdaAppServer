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
    private long id;
    private int price;
    private int status;
    List<OrderItem> orderItems;
    private long userId;
    private String userName;
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItem{
        private long id;
        private int quantity;
        private String name;

    }
}
