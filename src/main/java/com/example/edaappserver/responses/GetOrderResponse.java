package com.example.edaappserver.responses;

import com.example.edaappserver.restaurant.OrderItemEntity;
import com.example.edaappserver.user.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private Long id;

    private int status;
    /* todo
    пока думаю, наверное в духе
    0-заказ ожидает оплаты
    1-заказ оплачен
    2-заказ готов
    3-заказ отменен
    4- ...
    */
    private List<OrderItemEntity> orderItemEntityList;

    private UserEntity user;
}
