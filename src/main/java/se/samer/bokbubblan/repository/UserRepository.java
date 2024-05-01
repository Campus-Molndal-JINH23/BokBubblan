package se.samer.bokbubblan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Inga ytterligare metoder behövs för närvarande, MongoRepository ger grundläggande CRUD-operationer
}