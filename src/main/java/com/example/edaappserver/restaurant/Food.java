package com.example.edaappserver.restaurant;

import jakarta.persistence.*;

@Entity
@Table
public class Food<T> implements Comparable<Food> {
    @Id
    @SequenceGenerator(
            name = "food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    private int id;
    private int quantity;
    private double price;
    private String name;
    private String pictureUrl;

    public Food() {
    }

    public Food(int quantity, double price, String name, String pictureUrl) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public Food(int id, int quantity, double price, String name, String pictureUrl) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public int compareTo(Food o) {
        int id = o.getId();
        try {
            if (this.id < id)
                return -1;
            else if (this.id == id)
                return 0;
            else if (this.id > id)
                return 1;
        } catch(Exception e) {
            return 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}

