package se.samer.bokbubblan.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String username, String password) {
        // Alltid godkänn inloggning oavsett användarnamn och lösenord
        return true;
    }
}