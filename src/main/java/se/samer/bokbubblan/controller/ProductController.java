package se.samer.bokbubblan.controller;

import org.springframework.web.bind.annotation.*;
import se.samer.bokbubblan.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    // Simulering av databas med produkter
    private static Map<Long, Product> productMap = new HashMap<>();

    static {
        productMap.put(1L, new Product(1L, "Bok 1", "Ett bokexempel", 129.99, "Deckare"));
        productMap.put(2L, new Product(2L, "Bok 2", "Ett annat bokexempel", 19.99, "Självbiografi"));
        // Lägg till fler exempelprodukter här
    }

    // Visa alla produkter
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    // Visa en specifik produkt baserat på ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productMap.get(id);
    }

    // Lägg till en ny produkt
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setId((long) (productMap.size() + 1));
        productMap.put(product.getId(), product);
        return product;
    }

    // Uppdatera en befintlig produkt
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existingProduct = productMap.get(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        return existingProduct;
    }

    // Ta bort en produkt
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productMap.remove(id);
    }
}