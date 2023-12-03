package com.example.edaappserver.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CategoryEntity {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Getter
    private int id;
    @Getter
    private String category;
    @Getter
    private String categoryName;
    @OneToMany(mappedBy = "categoryEntity")
    private List<MenuItemEntity> menuItems;
}
