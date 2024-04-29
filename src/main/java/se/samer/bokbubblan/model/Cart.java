package se.samer.bokbubblan.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Cart")
public class Cart {
    @Id
    private String id;
    private List<Product> products = new ArrayList<>(); //lista med produkter i vagnen
    @Setter
    @Getter
    private boolean digitalLoanEligible; // Indicates if digital loan is eligible

}
