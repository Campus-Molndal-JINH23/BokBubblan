package se.samer.bokbubblan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_profile")
public class UserProfile {

    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private boolean acceptedTerms;

    public UserProfile(String username, String email, String password, boolean acceptedTerms) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.acceptedTerms = acceptedTerms;
    }
}