package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
