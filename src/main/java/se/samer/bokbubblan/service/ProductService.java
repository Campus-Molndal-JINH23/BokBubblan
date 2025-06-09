package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        try {
            // Try to get from database first
            List<Product> dbProducts = productRepository.findAll();
            if (dbProducts.isEmpty()) {
                // If database is empty, return demo data
                System.out.println("Database is empty, using demo data");
                return getDemoProducts();
            }
            return dbProducts;
        } catch (Exception e) {
            // If database is not available, return demo data
            System.out.println("Database not available, using demo data");
            return getDemoProducts();
        }
    }

    //för KUNDVAGN
    public Product getProductById(String productId) {
        try {
            Optional<Product> dbProduct = productRepository.findById(productId);
            if (dbProduct.isPresent()) {
                return dbProduct.get();
            }
        } catch (Exception e) {
            System.out.println("Database not available for getProductById, checking demo data");
        }

        // Fallback to demo data
        return getDemoProducts().stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    //hämta produkter baserat på kategori på produktsida
    public List<Product> getProductsByCategory(String category) {
        try {
            List<Product> dbProducts = productRepository.findByCategory(category);
            if (!dbProducts.isEmpty()) {
                return dbProducts;
            }
        } catch (Exception e) {
            System.out.println("Database not available for getProductsByCategory, using demo data");
        }

        // Fallback to demo data
        return getDemoProducts().stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Product> searchProducts(String query) {
        try {
            // Try database search first
            List<Product> dbResults = productRepository.findByTitleContainingIgnoreCase(query);
            if (!dbResults.isEmpty()) {
                return dbResults;
            }
        } catch (Exception e) {
            System.out.println("Database not available for search, using demo data");
        }

        // Fallback to demo data search
        List<Product> allDemoProducts = getDemoProducts();

        // If query is empty, return empty list
        if (query == null || query.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Filter products based on search query (case-insensitive)
        return allDemoProducts.stream()
                .filter(product ->
                        product.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                product.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                                product.getDescription().toLowerCase().contains(query.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    // Demo products method for fallback data
    public List<Product> getDemoProducts() {
        List<Product> demoProducts = new ArrayList<>();

        // SIGNERADE FÖRSTAUTGÅVOR (Signed First Editions)
        demoProducts.add(new Product("demo_sf001", "Pippi Långstrump (Signerad förstautgåva)", 1945, "Astrid Lindgren",
                "Ursprunglig förstautgåva signerad av Astrid Lindgren själv. En sällsynt och värdefull bok för samlare.",
                "Signerade förstautgåvor", "SF011", 1250.0));

        demoProducts.add(new Product("demo_sf002", "Bröderna Lejonhjärta", 1973, "Astrid Lindgren",
                "Signerad förstautgåva av denna älskade barnbok om bröderna Jonathan och Skorpan.",
                "Signerade förstautgåvor", "SF012", 980.0));

        demoProducts.add(new Product("demo_sf003", "Millennium: Män som hatar kvinnor", 2005, "Stieg Larsson",
                "Första boken i den berömda Millennium-serien, signerad förstautgåva.",
                "Signerade förstautgåvor", "SF013", 450.0));

        demoProducts.add(new Product("demo_sf004", "Utvandrarna", 1949, "Vilhelm Moberg",
                "Första boken i Utvandrareserien, signerad förstautgåva av denna svenska klassiker.",
                "Signerade förstautgåvor", "SF014", 1680.0));

        // SÄLLSYNTA FANTASYSERIER (Rare Fantasy Series)
        demoProducts.add(new Product("demo_sfs001", "Sagan om ringen - Härskarringen", 1954, "J.R.R. Tolkien",
                "Sällsynt första svenska upplaga av fantasyklassikern om hobbiten Frodo och härskarringen.",
                "Sällsynta fantasyserier", "SFS011", 890.0));

        demoProducts.add(new Product("demo_sfs002", "Narnia: Lejonet, häxan och garderoben", 1950, "C.S. Lewis",
                "Första svenska utgåvan av denna magiska berättelse om Lucy och hennes syskon.",
                "Sällsynta fantasyserier", "SFS012", 750.0));

        demoProducts.add(new Product("demo_sfs003", "Mio, min Mio", 1954, "Astrid Lindgren",
                "Lindgrens fantasyberättelse om pojken som blir prins i Landet i Fjärran.",
                "Sällsynta fantasyserier", "SFS013", 820.0));

        demoProducts.add(new Product("demo_sfs004", "Ronia Rövardotter", 1981, "Astrid Lindgren",
                "Äventyrsberättelse om rövardottern Ronia och hennes vänskap med Birk.",
                "Sällsynta fantasyserier", "SFS014", 690.0));

        // INTERAKTIVA BARNBÖCKER (Interactive Children's Books)
        demoProducts.add(new Product("demo_ib001", "Emil i Lönneberga (Interaktiv utgåva)", 2023, "Astrid Lindgren",
                "Modern interaktiv version med ljud, animationer och aktiviteter för barn.",
                "Interaktiva barnböcker", "IB011", 320.0));

        demoProducts.add(new Product("demo_ib002", "Bamse och Kylskåpsfabriken", 2022, "Rune Andréasson",
                "Interaktiv bok med ljud från TV-serien och roliga aktiviteter för barn.",
                "Interaktiva barnböcker", "IB012", 280.0));

        demoProducts.add(new Product("demo_ib003", "Pettson och Findus: Pannkakstårtan", 2023, "Sven Nordqvist",
                "Interaktiv version med receptsamling och aktiviteter med Pettson och katten Findus.",
                "Interaktiva barnböcker", "IB013", 350.0));

        demoProducts.add(new Product("demo_ib004", "Alfons Åberg: En vanlig dag", 2022, "Gunilla Bergström",
                "Digital interaktiv bok med animationer och aktiviteter med Alfons.",
                "Interaktiva barnböcker", "IB014", 295.0));

        demoProducts.add(new Product("demo_ib005", "Mumin: Trollkarlens hatt", 2023, "Tove Jansson",
                "Klassisk Mumin-berättelse i interaktiv format med ljud och animationer.",
                "Interaktiva barnböcker", "IB015", 380.0));

        return demoProducts;
    }
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