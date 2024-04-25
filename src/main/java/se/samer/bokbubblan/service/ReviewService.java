package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import se.samer.bokbubblan.model.Review;
import se.samer.bokbubblan.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String createReview(int rating, String bookId) {
        Review review = new Review(rating, bookId);
        reviewRepository.save(review);
        // Returnera URL:en för omdirigeringen
        return "redirect:/review_added";
    }
}