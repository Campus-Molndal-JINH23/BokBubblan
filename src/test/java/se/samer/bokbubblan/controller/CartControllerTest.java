package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.samer.bokbubblan.model.Cart;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.service.CartService;
import se.samer.bokbubblan.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CartControllerTest {

    @InjectMocks
    private CartController cartController;

    @Mock
    private CartService cartService;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testViewCart() {
        // Arrange
        Cart cart = new Cart();
        double totalPrice = 100.0;
        when(cartService.getCart()).thenReturn(cart);
        when(cartService.calculateTotalPrice()).thenReturn(totalPrice);

        // Act
        String viewName = cartController.viewCart(model);

        // Assert
        assertEquals("cart", viewName);
        verify(model).addAttribute("cart", cart);
        verify(model).addAttribute("totalPrice", totalPrice);
    }

    @Test
    public void testAddToCart() {
        // Arrange
        String productId = "123";
        Product product = new Product();
        when(productService.getProductById(productId)).thenReturn(product);

        // Act
        String viewName = cartController.addToCart(productId);

        // Assert
        assertEquals("redirect:/products", viewName);
        verify(cartService).addToCart(product);
    }

    @Test
    public void testRemoveFromCart() {
        // Arrange
        String productId = "123";
        Product product = new Product();
        when(productService.getProductById(productId)).thenReturn(product);

        // Act
        String viewName = cartController.removeFromCart(productId);

        // Assert
        assertEquals("redirect:/cart", viewName);
        verify(cartService).removeFromCart(product);
    }

    // Add more test methods for other controller methods similarly

}
