/*package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.CustomerProfile;
import se.samer.bokbubblan.model.Review;
import se.samer.bokbubblan.repository.CustomerProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerProfileRepository customerProfileRepository;

    @Autowired
    public CustomerService(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    public CustomerProfile getCustomerById(Long customerId) {
        Optional<CustomerProfile> customerProfileOptional = customerProfileRepository.findById(customerId);
        return customerProfileOptional.orElse(null);
    }

    public CustomerProfile createCustomerProfile(String name, String email) {
        CustomerProfile customerProfile = new CustomerProfile(name, email);
        return customerProfileRepository.save(customerProfile);
    }

    public void updateCustomerProfile(Long customerId, String name, String email) {
        CustomerProfile customerProfile = customerProfileRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Kund med ID " + customerId + " hittades inte"));
        customerProfile.updateProfile(name, email);
        customerProfileRepository.save(customerProfile);
    }

    public void addReviewToCustomerProfile(Long customerId, Review review) {
        CustomerProfile customerProfile = customerProfileRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Kund med ID " + customerId + " hittades inte"));
        customerProfile.addReview(review);
        customerProfileRepository.save(customerProfile);
    }
}*/