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
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        if (userProfile == null || !userProfile.getPassword().equals(password)) {
            return null;
        }
        return userProfile;
    }
}