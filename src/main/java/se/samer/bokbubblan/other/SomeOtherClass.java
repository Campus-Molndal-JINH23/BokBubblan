package se.samer.bokbubblan.other;

import se.samer.bokbubblan.filter.ProductFilter;
import se.samer.bokbubblan.filter.ProductSearch;
import se.samer.bokbubblan.model.Product;

import java.util.List;
public class SomeOtherClass {

    public void someMethod(List<Product> products, String category, String keyword) {
        // Använder ProductFilter för att filtrera produkter efter kategori
        ProductFilter filter = new ProductFilter();
        List<Product> filteredByCategory = filter.filterByCategory(products, category);

        // Använder ProductSearch för att söka efter produkter baserat på namnet på produkten
        ProductSearch search = new ProductSearch();
        List<Product> searchedByName = search.searchByName(products, keyword);

        // Använder ProductFilter för att sortera produkterna efter pris
        List<Product> sortedByPrice = filter.sortByPrice(products, "asc");

        // Använder ProductFilter för att filtrera produkter baserat på prisintervall
        List<Product> filteredByPriceRange = filter.filterByPriceRange(products, 10.0, 50.0);

        // Använder ProductFilter för att filtrera produkter baserat på namn
        List<Product> filteredByName = filter.filterByName(products, "book");

        // Skriver ut resultaten på de filtrerade, sorterade eller sökta produkterna
        System.out.println("Filtered by category:");
        filteredByCategory.forEach(System.out::println);

        System.out.println("Searched by name:");
        searchedByName.forEach(System.out::println);

        System.out.println("Sorted by price:");
        sortedByPrice.forEach(System.out::println);

        System.out.println("Filtered by price range:");
        filteredByPriceRange.forEach(System.out::println);

        System.out.println("Filtered by name:");
        filteredByName.forEach(System.out::println);
    }
}
