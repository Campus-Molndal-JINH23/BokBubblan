package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TermsController {

    @GetMapping("/terms")
    public String termsPage() {
        return "terms"; // Returnera namnet på sidan för användarvillkoren (t.ex. terms.html)
    }
}