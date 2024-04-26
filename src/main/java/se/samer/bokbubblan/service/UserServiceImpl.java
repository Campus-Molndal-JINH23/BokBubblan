package se.samer.bokbubblan.service;

import org.springframework.stereotype.Service;
import se.samer.bokbubblan.model.User;
import se.samer.bokbubblan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}