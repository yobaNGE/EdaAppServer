package com.example.edaappserver.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditFoodRequest {
    private int id;
    private int quantity;
    private double price;
    private String name;
}
