package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Constructor injection: Dependency injection av ProductRepository vid skapande av ProductService

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //för KUNDVAGN
    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElse(null);
    }
/*
    public List<Product> getAllProducts() {
        // Create a temporary hardcoded list of Product objects
        return Arrays.asList(
                new Product("1", "Test Book", 2020, "Author Name", "Description", "Category", "001", 29.99),
                new Product("2", "Another Book", 2021, "Another Author", "Another Description", "Another Category", "002", 19.99)
        );
    }

 */


/*

    // Hämta alla produkter
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    */

/*
    // Hämta produkt baserat på ID
    public Product getProductById(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    // Lägg till en ny produkt
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Uppdatera en befintlig produkt
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Ta bort en produkt baserat på ID
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

     */
}