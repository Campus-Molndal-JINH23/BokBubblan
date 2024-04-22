package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.samer.bokbubblan.model.UserProfile;
import se.samer.bokbubblan.repository.UserProfileRepository;


@Service
public class AuthService {
    private final UserProfileRepository userProfileRepository;
    @Autowired
    public AuthService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // Metod för att registrera en ny användare
    public UserProfile registerUser(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    // Metod för att logga in en användare
    public UserProfile loginUser(String username, String password) {

        // Använder findByUsername för att hämta användaren från databasen
        UserProfile userProfile = userProfileRepository.findByUsername(username);

        // Om användaren inte finns eller om lösenordet inte stämmer, så returneras null
        if (userProfile == null || !userProfile.getPassword().equals(password)) {
            return null;
        }
        // Annars returnernas användarprofilen
        return userProfile;
    }
}
