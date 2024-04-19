package se.samer.bokbubblan.model;

public class UserProfile {

    private Long id;
    private String username;
    private String email;
    private String password;
    private boolean acceptedTerms;

    // Konstruktor
    public UserProfile(String username, String email, String password, boolean acceptedTerms) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.acceptedTerms = acceptedTerms;
    }

    // Getter och setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(boolean acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }
}