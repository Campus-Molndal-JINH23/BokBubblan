package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderConfirmationControllerTest {

    @Test
    public void testShowOrderConfirmationPage() {
        //arrange
        OrderConfirmationController orderConfirmationController = new OrderConfirmationController();
        //act
        String viewName = orderConfirmationController.showOrderConfirmationPage();
        //assert
        assertEquals("order_confirmation", viewName);
    }
}
