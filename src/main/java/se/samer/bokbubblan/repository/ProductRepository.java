package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category); // för att kunna sortera på kategorier

    List<Product> findByTitleContainingIgnoreCase(String title); // för att söka böcker baserat på titel
}
