package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.repository.ProductRepository;



import java.util.List;


@Component
public class ProductController {

    private ProductRepository productRepository = null;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // Visa alla produkter
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Visa en specifik produkt baserat på ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }


    // Lägg till en ny produkt
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Uppdatera en befintlig produkt
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        return productRepository.save(updatedProduct);
    }

    // Ta bort en produkt
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }

}