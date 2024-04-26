package se.samer.bokbubblan.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import se.samer.bokbubblan.controller.ProductController;
import se.samer.bokbubblan.filter.ProductFilter;
import se.samer.bokbubblan.service.ProductService;

@Configuration
public class AppConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    // Bean for ProductService
    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    // Bean for ProductController
    @Bean
    public ProductController productController(ProductService productService) {
        return new ProductController(productService);
    }

    // Bean for MongoTemplate to connect to MongoDB
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = MongoClients.create(mongoUri);
        return new MongoTemplate(mongoClient, "Bokbubblan"); // Adjust database name if necessary
    }

    // Bean för ProductFilter
    @Bean
    public ProductFilter productFilter() {
        return new ProductFilter();
    }
}