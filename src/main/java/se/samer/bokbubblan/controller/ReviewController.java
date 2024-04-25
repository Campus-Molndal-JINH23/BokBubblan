package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.samer.bokbubblan.model.Review;
import se.samer.bokbubblan.service.ReviewService;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/add_review")
    public String showAddReviewForm() {
        return "add_review";
    }

    @PostMapping("/add_review")
    public String addReview(@RequestParam int rating, @RequestParam String bookId) {
        // Anropa createReview och få tillbaka omdirigerings-URL:en
        return reviewService.createReview(rating, bookId);
    }

    @GetMapping("/review_added")
    public String showReviewAddedPage() {
        return "review_added";
    }
}