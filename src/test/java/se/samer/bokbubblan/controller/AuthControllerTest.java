package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.samer.bokbubblan.service.AuthService;
import se.samer.bokbubblan.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginPage() {
        //act
        String viewName = authController.loginPage();

        //assert
        assertEquals("login", viewName);
    }

    @Test
    public void testRegisterPage() {
        //act
        String viewName = authController.registerPage();

        //assert
        assertEquals("register", viewName);
    }

    @Test
    public void testRegistrationSuccessPage() {
        //act
        String viewName = authController.registrationSuccessPage();

        //assert
        assertEquals("registration-success", viewName);
    }
}
