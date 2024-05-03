package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.samer.bokbubblan.model.UserProfile;

@Controller
public class UserProfileController {

    // This method would ideally be replaced with one that retrieves user data from a service or database
    private UserProfile getDummyUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername("Carro");
        userProfile.setEmail("carolina.correia363@hotmail.com");
        // Add more user details as needed
        return userProfile;
    }

    @GetMapping("/user_profile")
    public String userProfile(Model model) {
        // Get user profile data (replace this with actual data retrieval logic)
        UserProfile userProfile = getDummyUserProfile();

        // Add user profile data to the model
        model.addAttribute("userProfile", userProfile);

        // Return the name of the HTML file for the user profile page
        return "user_profile";
    }
}
