package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.UserProfile;
@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    UserProfile findByUsername(String username);
}