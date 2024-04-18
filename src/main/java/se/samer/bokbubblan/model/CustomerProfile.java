package se.samer.bokbubblan.model;

import se.samer.bokbubblan.model.Review;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfile {

    private String name;
    private String email;
    private List<Review> reviews;

    public CustomerProfile(String name, String email) {
        this.name = name;
        this.email = email;
        this.reviews = new ArrayList<>();
    }

    public void updateProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}