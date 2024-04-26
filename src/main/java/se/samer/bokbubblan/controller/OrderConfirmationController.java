package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order_confirmation")
public class OrderConfirmationController {

    @GetMapping
    public String showOrderConfirmationPage() {
        return "order_confirmation"; //skicka till bekfräfelsesida
    }
}
