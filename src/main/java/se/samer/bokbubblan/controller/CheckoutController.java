package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.samer.bokbubblan.model.Cart;
import se.samer.bokbubblan.service.CartService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final CartService cartService;

    @Autowired
    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping
    public String showCheckoutForm(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);

        //beräkna pris på kundvagn + leveranskostnad 75kr
        double totalPrice = cartService.calculateTotalPrice() + 75;

        model.addAttribute("totalPrice", totalPrice);
        return "checkout"; //retur kassa
    }



    /* @GetMapping
    public String showCheckoutForm(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", cartService.calculateTotalPrice());
        return "checkout"; //retur kassan
    } */

    @PostMapping("/order_confirmation")
    public String handleCheckout() {
        //låtsas skicka mail
        return "order_confirmation"; //skicka till bekräftelsesida vid klar
    }

    @GetMapping("/checkout_confirmation")
    public String showCheckoutConfirmationPage() {
        return "order_confirmation"; //retur bekräftelse
    }

    //funktion för klarna kostnaden
    private double addKlarnaFee(double totalPrice) {
        return totalPrice + 19; //Klarna 19kr
    }
}