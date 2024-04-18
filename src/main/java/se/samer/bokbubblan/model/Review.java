package se.samer.bokbubblan.model;



public class Review {
    private String title;
    private String description;
    private int rating;

    // Konstruktor
    public Review(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    // Getters och setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}