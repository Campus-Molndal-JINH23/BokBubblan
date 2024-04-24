package se.samer.bokbubblan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.samer.bokbubblan.model.CustomerProfile;
import se.samer.bokbubblan.model.Review;
import se.samer.bokbubblan.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public String getCustomerProfile(@PathVariable Long customerId, Model model) {
        CustomerProfile customerProfile = customerService.getCustomerById(customerId);
        model.addAttribute("customerProfile", customerProfile);
        return "customer";
    }

    @GetMapping("/{customerId}/reviews")
    public String getCustomerReviews(@PathVariable Long customerId) {
        // Hämta recensioner för kunden
        return "reviews";
    }

    @GetMapping("/create")
    public String showCreateCustomerForm() {
        return "create_customer";
    }

    @PostMapping
    public String createCustomerProfile(@RequestParam String name, @RequestParam String email) {
        customerService.createCustomerProfile(name, email);
        return "redirect:/";
    }

    @GetMapping("/{customerId}/update")
    public String showUpdateCustomerForm(@PathVariable Long customerId, Model model) {
        CustomerProfile customerProfile = customerService.getCustomerById(customerId);
        model.addAttribute("customerProfile", customerProfile);
        return "update_customer";
    }

    @PostMapping("/{customerId}/update")
    public String updateCustomerProfile(@PathVariable Long customerId, @RequestParam String name, @RequestParam String email) {
        customerService.updateCustomerProfile(customerId, name, email);
        return "redirect:/customers/" + customerId;
    }

    @GetMapping("/{customerId}/reviews/create")
    public String showCreateReviewForm(@PathVariable Long customerId) {
        // Visa formulär för att lägga till recension
        return "create_review";
    }

    @PostMapping("/{customerId}/reviews")
    public String addReviewToCustomerProfile(@PathVariable Long customerId, @ModelAttribute Review review) {
        customerService.addReviewToCustomerProfile(customerId, review);
        return "redirect:/customers/" + customerId + "/reviews";
    }
}