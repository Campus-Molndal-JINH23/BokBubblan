package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.CustomerProfile;

@Repository
public interface CustomerProfileRepository extends MongoRepository<CustomerProfile, Long> {
}
