package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.samer.bokbubblan.model.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    UserProfile findByUsername(String username);
}