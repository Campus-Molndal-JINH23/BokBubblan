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
        //arrange
        Cart cart = new Cart();
        double totalPrice = 100.0;
        when(cartService.getCart()).thenReturn(cart);
        when(cartService.calculateTotalPrice()).thenReturn(totalPrice);

        //act
        String viewName = checkoutController.showCheckoutForm(model);

        //assert
        assertEquals("checkout", viewName);
        verify(model).addAttribute("cart", cart);
        verify(model).addAttribute("totalPrice", totalPrice + 75); // Leveranskostnad 75kr tillagd
    }

    @Test
    public void testHandleCheckout() {
        //act
        String viewName = checkoutController.handleCheckout();

        //act & assert
        assertEquals("order_confirmation", viewName);
    }

    @Test
    public void testShowCheckoutConfirmationPage() {
        //act
        String viewName = checkoutController.showCheckoutConfirmationPage();

        //assert
        assertEquals("order_confirmation", viewName);
    }
}

