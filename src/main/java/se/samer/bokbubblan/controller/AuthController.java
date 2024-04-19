package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returnerar namnet login-sida (login.html)
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Returnerar namnet på registreringssida (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        // Här kan du spara användaruppgifterna i databasen och göra andra nödvändiga åtgärder för att registrera användaren
        return "redirect:/registration-success"; // Omdirigera till en sida som bekräftar registreringen
    }

    @GetMapping("/registration-success")
    public String registrationSuccessPage() {
        return "registration-success"; // Returnerar namnet på sidan som bekräftar registreringen (registration-success.html)
    }
}