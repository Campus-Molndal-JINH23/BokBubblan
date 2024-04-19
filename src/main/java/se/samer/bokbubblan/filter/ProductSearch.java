package se.samer.bokbubblan.filter;

import se.samer.bokbubblan.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductSearch {

    public List<Product> searchByName(List<Product> products, String keyword) {
        return products.stream()
                .filter(product -> product.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}