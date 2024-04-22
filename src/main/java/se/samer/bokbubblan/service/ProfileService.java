package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.UserProfile;
import se.samer.bokbubblan.repository.UserProfileRepository;

import java.util.Optional;

@Service
public class ProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public ProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // Hämta användarprofilen med hjälp av användar-id
    public UserProfile getUserById(Long userId) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(String.valueOf(userId));
        return userProfileOptional.orElse(null);
    }

    // Uppdaterar användarens profil
    public UserProfile updateUser(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    // Raderar användarprofilen baserat på användar-id
    public void deleteUser(Long userId) {
        userProfileRepository.deleteById(String.valueOf(userId));
    }
}
