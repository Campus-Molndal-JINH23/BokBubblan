package se.samer.bokbubblan.repository;

import se.samer.bokbubblan.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class FakeUserRepository implements MongoRepository<User, String> {
    public abstract void saveUser(User user);
}