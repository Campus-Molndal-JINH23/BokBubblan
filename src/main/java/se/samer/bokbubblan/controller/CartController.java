package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.samer.bokbubblan.model.Cart;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.service.CartService;
import se.samer.bokbubblan.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    private ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }
    @GetMapping
    public String viewCart(Model model) {
        // hämta kundvagn och totalpris
        Cart cart = cartService.getCart();
        double totalPrice = cartService.calculateTotalPrice();

        //lägg till i kundvagn och totalpris
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);

        return "cart"; //retur html sidan
    }
    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") String productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cartService.addToCart(product);
        } else {
            // Produkt hittades inte, kan lägga till lämplig felhantering här
            System.out.println("Produkten med ID " + productId + " hittades inte.");
        }
        return "redirect:/products"; // Hamna på produktsidan efter att ha lagt till
    }





    //visa kundvagn
    /* @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "cart"; //retur namn på html för att visa vagn
    }  */

    /* fungerande
    @PostMapping("/add/{productId}")

    public String addToCart(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cartService.addToCart(product);
        } else {
            // Produkt hittades inte, kan lägga till lämplig felhantering här
            System.out.println("Produkten med ID " + productId + " hittades inte.");
        }
        return "redirect:/products"; // Hamna på produktsidan efter att ha lagt till
    } /*


    //lägg till
    /*@PostMapping("/add/{productId}")
    public String addToCart(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        cartService.addToCart(product);
        return "redirect:/products"; //hamna på produkterna efter man lagt till.
    } */

    //ta bort
    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        cartService.removeFromCart(product);
        return "redirect:/cart";
    }

    //uppdatera antal produkter
    @PostMapping("/update/{productId}")
    public String updateCart(@PathVariable String productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        cartService.updateCart(product, quantity);
        return "redirect:/cart"; //vara kvar i kundvagn efter uppdatering
    }

    //nollställ kundvagn
    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart"; //vara kvar i kundvagn efter du tömt
    }

    //för produktkort
    @GetMapping("/product/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product_card"; // Ersätt "product_card" med namnet på HTML-filen för produktdetaljer
    }


}