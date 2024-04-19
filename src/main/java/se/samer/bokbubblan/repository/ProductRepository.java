package se.samer.bokbubblan.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import se.samer.bokbubblan.model.Product;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}

