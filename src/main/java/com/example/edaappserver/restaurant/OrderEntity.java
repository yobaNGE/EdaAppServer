package com.example.edaappserver.restaurant;

import com.example.edaappserver.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ordersTable")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    @Setter(AccessLevel.NONE)
    private Long id;

    private int status;
    /* todo
    пока думаю, наверное в духе санта клауса
    0-заказ ожидает оплаты
    1-заказ оплачен
    2-заказ готов
    3-заказ отменен
    4-...
    */

    @OneToMany(targetEntity = OrderItemEntity.class, cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemListList;

    @ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;



//    private int[] foodId;
//    // 1:2:3
//    private int[] foodAmount;


//    private long userId;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderItemListList=" + orderItemListList +
                ", user=" + user +
                '}';
    }
}
