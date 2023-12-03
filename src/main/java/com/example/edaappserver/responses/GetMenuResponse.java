package com.example.edaappserver.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMenuResponse {
    private int id;
    private int quantity;
    private double price;
    private String name;
    private String pictureUrl;
}
