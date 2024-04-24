package se.samer.bokbubblan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import se.samer.bokbubblan.model.Cart;
import org.springframework.data.mongodb.core.query.Query;


@Repository
public class CartRepository {
    private static MongoTemplate mongoTemplate;

    @Autowired
    public CartRepository(MongoTemplate mongoTemplate) {
        CartRepository.mongoTemplate = mongoTemplate; // Tilldela det injicerade mongoTemplate-objektet till det statiska fältet
    }

    public static Cart save(Cart cart) {
        return mongoTemplate.save(cart);
    }


    public Cart findById(String id) {
        return mongoTemplate.findById(id, Cart.class);
    }

    public void deleteById(String id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Cart.class);
    }
}