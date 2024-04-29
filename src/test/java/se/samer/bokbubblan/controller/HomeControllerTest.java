package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTest {

    @Test
    public void testHome() {
        // Arrange
        HomeController homeController = new HomeController();

        // Act
        String viewName = homeController.home();

        // Assert
        assertEquals("index", viewName);
    }
}

