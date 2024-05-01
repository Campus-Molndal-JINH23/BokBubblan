package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.service.ProductService;
import se.samer.bokbubblan.filter.ProductFilter;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    private ProductFilter productFilter;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        this.productFilter = new ProductFilter();
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // Ensure this matches your Thymeleaf template file name
    }

    ///////////////

    //interaktiva barnböcker
    @GetMapping("/interaktiva_barnbocker")
    public String listInteraktivaBarnbocker(Model model) {
        List<Product> products = productService.getProductsByCategory("Interaktiva barnböcker");
        model.addAttribute("products", products);
        return "interaktiva_barnbocker"; //retur html sida
    }

    //signerade förstautgåvor
    @GetMapping("/signerade_forstautgavor")
    public String listSigneradeForstautgavor(Model model) {
        List<Product> products = productService.getProductsByCategory("Signerade förstautgåvor");
        model.addAttribute("products", products);
        return "signerade_forstautgavor"; //retur html sidan
    }

    //sällsynta fantasyserier
    @GetMapping("/sallsynta_fantasyserier")
    public String listSallsyntaFantasyserier(Model model) {
        List<Product> products = productService.getProductsByCategory("Sällsynta fantasyserier");
        model.addAttribute("products", products);
        return "sallsynta_fantasyserier"; //retur html sidan
    }

    @GetMapping("/error")
    public String handleError() {
        return "error"; // Skapa en error.html-sida för att visa ett felmeddelande
    }

    @GetMapping("/filterByPriceRange")
    @ResponseBody
    public List<Product> filterByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productFilter.filterByPriceRange(productService.getAllProducts(), minPrice, maxPrice);
    }

    @GetMapping("/filterByName")
    @ResponseBody
    public List<Product> filterByName(@RequestParam String keyword) {
        return productFilter.filterByName(productService.getAllProducts(), keyword);
    }

    @GetMapping("/sortByPrice")
    @ResponseBody
    public List<Product> sortByPrice(@RequestParam String order) {
        return productFilter.sortByPrice(productService.getAllProducts(), order);
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query, Model model) {
        List<Product> matchingBooks = productService.searchProducts(query);
        model.addAttribute("books", matchingBooks);
        return "search_results";
    }

    @GetMapping("/search-results")
    public String showSearchResults(Model model) {
        return "search_results";
    }


    //för produktkort när man klickar på "läs mer" i varukatalog
    @GetMapping("/product_card/{productId}")
    public String showProductCard(@PathVariable String productId, Model model) {
        //hämta på id
        Product product = productService.getProductById(productId);
        //kolla om den finns
        if (product != null) {
            //skicka info till produktsidan
            model.addAttribute("product", product);
            return "product_card"; //skickas till sidan som ska visas endast det produktkortet
        } else {
            return "redirect:/error"; //error om det inte finns
        }
    }
}