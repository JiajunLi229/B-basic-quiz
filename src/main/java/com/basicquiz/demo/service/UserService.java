package com.basicquiz.demo.service;
import com.basicquiz.demo.domain.User;
import com.basicquiz.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Integer id) {

        return userRepository.findById(id);
    }

    public Integer createUserInformation(User user) {
        return userRepository.save(user).getId();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
