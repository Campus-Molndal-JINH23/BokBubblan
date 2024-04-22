package se.samer.bokbubblan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private int year;
    private String author;
    private String description;
    private String category;
    private String itemNumber;
    private double price;
}