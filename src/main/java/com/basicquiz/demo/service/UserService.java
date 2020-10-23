package com.basicquiz.demo.service;
import com.basicquiz.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    //TODO GTB-工程实践: - UserMap 命名不好，变量名通常不以大写字母开头。另外，叫 users 即可，不需要总是加 map、list 等后缀。
    //TODO GTB-工程实践: - 通常，会 UserMap 抽象成一个 Repository 来实现，比如 InMemoryUserRepository。
    private final Map<Long, User> UserMap = new HashMap<>();

    public UserService() {
        UserMap.put((long) 1, new User( 1, "Jiajun", 24, "https://inews.gtimg.com/newsapp_match/0/3581582328/0", "hello"));
    }

    public User getUserById(Long id) {
        //TODO GTB-工程实践: - UserService.java:20 建议此处使用 Optional API。
        User user = UserMap.get(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    public Long createUserInformation(User user) {
        //TODO GTB-完成度: - 不要用 size() + 1 作为新 user 的 id，用单独的 sequence 字段来生成 id。
        user.setUserId(UserMap.size() + 1);
        UserMap.put(user.getUserId(), user);
        //TODO GTB-工程实践: - 通常创建成功后返回整个新创建的 resource，而不是仅仅只有 id。
        return user.getUserId();
    }
}
