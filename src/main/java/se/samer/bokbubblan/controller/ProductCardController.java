package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.service.ProductService;

@Controller
public class ProductCardController {

    private final ProductService productService;

    @Autowired
    public ProductCardController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public String getProductDetails(@PathVariable String productId, Model model) {
        //hämta produkt från servicen med id
        Product product = productService.getProductById(productId);

        //lägg till i model
        model.addAttribute("product", product);

        //retur kortet
        return "product_card";
    }
}
