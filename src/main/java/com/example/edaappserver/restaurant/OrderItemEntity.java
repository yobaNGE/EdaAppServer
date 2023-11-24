package com.example.edaappserver.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orderItems")
public class OrderItemEntity {
    @Id
    @SequenceGenerator(
            name = "orderItem_sequence",
            sequenceName = "orderItem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderItem_sequence"
    )
    private long id;
    private int quantity;
    @ManyToOne(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne(targetEntity = FoodEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private FoodEntity food;
}
