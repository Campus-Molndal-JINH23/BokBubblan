package se.samer.bokbubblan.filter;

import se.samer.bokbubblan.model.Product;

import java.util.List;
import java.util.stream.Collectors;
public class ProductFilter {

    // Metod för att ta fram produkten baserat på kategori
    public List<Product> filterByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList()); // Samlar de filtrerade produkterna i en lista och returnerar den
    }

    // Metod för att sortera produkterna efter pris i antingen stigande eller fallande (dyrast först eller billigast först)
    public List<Product> sortByPrice(List<Product> products, String order) {
        return products.stream()
                .sorted((p1, p2) -> order.equalsIgnoreCase("asc") ? Double.compare(p1.getPrice(), p2.getPrice()) : Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList()); // Samla de sorterade produkterna i en lista och returnera den
    }

    // Metod för att filtrera produkter baserat på prisintervall
    public List<Product> filterByPriceRange(List<Product> products, double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice) // Filtrera produkter inom det angivna prisintervallet
                .collect(Collectors.toList()); // Samla de filtrerade produkterna i en lista och returnera den
    }

    // Metod för att filtrera produkter baserat på ett sökord i produktnamnet
    public List<Product> filterByName(List<Product> products, String keyword) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase())) // Filtrera produkter med produktnamn som innehåller det angivna sökordet (case insensitive)
                .collect(Collectors.toList()); // Samla de filtrerade produkterna i en lista och returnera den
    }
}