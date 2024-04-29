package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TermsControllerTest {

    @Test
    void testTermsPage() {
        //arrange
        TermsController termsController = new TermsController();
        //act
        String viewName = termsController.termsPage();
        //assert
        assertEquals("terms", viewName);
    }
}
