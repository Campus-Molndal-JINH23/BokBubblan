package se.samer.bokbubblan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Bokbubblan")
public class Review {
    @Id
    private String id;
    private int rating;
    private String bookId;

    public Review(int rating, String bookId) {
        this.rating = rating;
        this.bookId = bookId;
    }
}