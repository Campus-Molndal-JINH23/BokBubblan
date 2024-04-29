package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.service.ProductService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductCardControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductCardController productCardController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetProductDetails() {
        //arrange
        String productId = "123";
        Product product = new Product(); // Skapa en dummyprodukt för teständamål
        //mocka ProductService för att få tillbaka en dummy
        when(productService.getProductById(productId)).thenReturn(product);
        //act
        String viewName = productCardController.getProductDetails(productId, model);
        //assert
        assertEquals("product_card", viewName);
    }
}

