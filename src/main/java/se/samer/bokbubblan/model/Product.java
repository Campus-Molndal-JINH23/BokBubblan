package se.samer.bokbubblan.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    // Getters och setters
    private String category; // Tillagd attribut

    // Konstruktor
    public Product(Long id, String name, String description, double price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}