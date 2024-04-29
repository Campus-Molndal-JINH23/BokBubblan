package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.samer.bokbubblan.service.ReviewService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @Mock
    private Model model;

    @InjectMocks
    private ReviewController reviewController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testShowAddReviewForm() {
        //arrange&act
        String viewName = reviewController.showAddReviewForm();
        //asseert
        assertEquals("add_review", viewName);
    }

    @Test
    void testAddReview() {
        //arrange
        int rating = 5;
        String bookId = "123";
        String redirectionUrl = "/redirect_url"; // Dummy redirection URL
        //mocka ReviewService för att returnera den dummy-URL:en
        when(reviewService.createReview(rating, bookId)).thenReturn(redirectionUrl);
        //act
        String actualUrl = reviewController.addReview(rating, bookId);
        //assert
        assertEquals(redirectionUrl, actualUrl);
    }

    @Test
    void testShowReviewAddedPage() {
        //arrange&act
        String viewName = reviewController.showReviewAddedPage();
        //assert
        assertEquals("review_added", viewName);
    }
}

