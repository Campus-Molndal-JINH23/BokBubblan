package se.samer.bokbubblan.model;

import lombok.Data;

@Data
public class Review {
    private String title;
    private String description;
    private int rating;

    public Review(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }
}