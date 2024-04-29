package se.samer.bokbubblan.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category); //för att kunna sortera på kategorier
    //Optional<Product> findById(String id); //hämta product för ID

}

