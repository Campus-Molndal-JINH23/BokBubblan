package se.samer.bokbubblan.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import se.samer.bokbubblan.model.Product;
public interface ProductRepository extends MongoRepository<Product, Long> {
}
