package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.samer.bokbubblan.model.Cart;
import se.samer.bokbubblan.service.CartService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutControllerTest {

    @InjectMocks
    private CheckoutController checkoutController;

    @Mock
    private CartService cartService;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowCheckoutForm() {
        // Arrange
        Cart cart = new Cart();
        double totalPrice = 100.0;
        when(cartService.getCart()).thenReturn(cart);
        when(cartService.calculateTotalPrice()).thenReturn(totalPrice);

        // Act
        String viewName = checkoutController.showCheckoutForm(model);

        // Assert
        assertEquals("checkout", viewName);
        verify(model).addAttribute("cart", cart);
        verify(model).addAttribute("totalPrice", totalPrice + 75); // Leveranskostnad 75kr tillagd
    }

    @Test
    public void testHandleCheckout() {
        // Act
        String viewName = checkoutController.handleCheckout();

        // Assert
        assertEquals("order_confirmation", viewName);
    }

    @Test
    public void testShowCheckoutConfirmationPage() {
        // Act
        String viewName = checkoutController.showCheckoutConfirmationPage();

        // Assert
        assertEquals("order_confirmation", viewName);
    }
}

