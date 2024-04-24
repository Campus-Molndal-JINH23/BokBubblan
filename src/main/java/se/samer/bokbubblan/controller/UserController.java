package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.samer.bokbubblan.model.UserProfile;
import se.samer.bokbubblan.service.ProfileService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ProfileService profileService;

    @Autowired
    public UserController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        UserProfile userProfile = profileService.getUserById(userId);
        model.addAttribute("userProfile", userProfile);
        return "user_profile"; // Returnera namnet på HTML-filen för användarprofilen
    }

    @PostMapping("/{userId}")
    public String updateUserProfile(@PathVariable Long userId, @ModelAttribute UserProfile userProfile, Model model) {
        UserProfile updatedProfile = profileService.updateUser(userProfile);
        model.addAttribute("userProfile", updatedProfile);
        return "profile_updated_successfully"; // Returnera namnet på HTML-filen för bekräftelse av uppdaterad profil
    }

    @DeleteMapping("/{userId}")
    public String deleteUserProfile(@PathVariable Long userId) {
        profileService.deleteUser(userId);
        return "redirect:/"; // Omdirigera till startsidan
    }
}