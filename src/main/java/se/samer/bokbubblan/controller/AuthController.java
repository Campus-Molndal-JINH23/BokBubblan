package se.samer.bokbubblan.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.samer.bokbubblan.model.User;
import se.samer.bokbubblan.service.AuthService;
import se.samer.bokbubblan.service.UserService;

@Controller
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returnerar namnet på inloggningssidan (login.html)
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isAuthenticated = authService.authenticate(username, password);
        if (isAuthenticated) {
            model.addAttribute("username", username);
            return "redirect:/user_profile"; // Omdirigera till den nya inloggade startsidan
        } else {
            // Authentication failed, add error message to model and return login page
            model.addAttribute("error", true);
            return "login"; // Return to login page with error message
        }
    }

    @GetMapping("/login-success")
    public String loginSuccessPage() {
        return "login-success"; // Returnera namnet på bekräftelsesidan
    }



    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Returnerar namnet på registreringssidan (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User newUser = new User(); // Skapa en ny användare
        newUser.setUsername(username); // Ange användarnamnet
        newUser.setEmail(email); // Ange e-postadressen
        newUser.setPassword(password); // Ange lösenordet
        newUser.setEnabled(true);
        userService.register(newUser); // Registrera användaren
        return "redirect:/user_profile"; // Omdirigera till bekräftelsesidan efter att registreringen är klar
    }

    @GetMapping("/registration-success")
    public String registrationSuccessPage() {
        return "registration-success"; // Returnera namnet på bekräftelsesidan
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Ogiltigförklara sessionen för att logga ut användaren
        return "redirect:/"; // Omdirigera till startsidan
    }
}