package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Constructor injection: Dependency injection av ProductRepository vid skapande av ProductService
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Hämta alla produkter
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

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
}