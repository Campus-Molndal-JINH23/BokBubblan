package se.samer.bokbubblan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
}