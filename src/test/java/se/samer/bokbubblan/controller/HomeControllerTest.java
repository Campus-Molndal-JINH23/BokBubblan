package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTest {

    @Test
    public void testHome() {
        //arrange
        HomeController homeController = new HomeController();

        //act
        String viewName = homeController.home();

        //assert
        assertEquals("index", viewName);
    }
}
