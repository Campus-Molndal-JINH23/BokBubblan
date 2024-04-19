package se.samer.bokbubblan.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String id;
    private String title;
    private int year;
    private String author;
    private String description;
    private String category;
    private String itemNumber;
    private double price;
    // Getters och setters


    // Konstruktor
    public Product(String id, String name, String description, double price, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.description = description;
        this.itemNumber = itemNumber;
        this.price = price;
    }
    //konstruktor för att kunna använda objekt utan att behöva specificera alla attribut
    public Product() {
    }
}