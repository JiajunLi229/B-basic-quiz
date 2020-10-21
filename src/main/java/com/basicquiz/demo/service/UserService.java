package com.basicquiz.demo.service;
import com.basicquiz.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Long, User> UserMap = new HashMap<>();

    public UserService() {
        UserMap.put((long) 1, new User( 1, "Jiajun", 24, "https://inews.gtimg.com/newsapp_match/0/3581582328/0", "hello"));
    }

    public User getUserById(Long id) {
        User user = UserMap.get(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    public Long createUserInformation(User user) {
        user.setUserId(UserMap.size() + 1);
        UserMap.put(user.getUserId(), user);
        return user.getUserId();
    }
}
