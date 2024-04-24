package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.samer.bokbubblan.model.UserProfile;
import se.samer.bokbubblan.service.AuthService;

@Controller
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returnerar namnet login-sida (login.html)
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Returnerar namnet på registreringssida (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        UserProfile userProfile = new UserProfile(username, email, password, true); // Skapa användarprofilen med acceptedTerms satt till true eftersom användaren är registrerad
        authService.registerUser(userProfile); // Registrera användaren
        model.addAttribute("username", username); // Lägg till användarnamnet i modellen för bekräftelse
        return "registration-success"; // Omdirigera till en sida som bekräftar registreringen (registration-success.html)
    }

    @GetMapping("/registration-success")
    public String registrationSuccessPage() {
        return "registration-success"; // Returnerar namnet på sidan som bekräftar registreringen (registration-success.html)
    }
}