package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

}