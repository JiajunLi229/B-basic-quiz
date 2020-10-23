package com.basicquiz.demo.controller;
import com.basicquiz.demo.domain.User;
import com.basicquiz.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> createUserInformation(@RequestBody @Valid User user) {
        long id = userService.createUserInformation(user);
        //TODO GTB-知识点: - 用了 @ResponseStatus 和 @RestController 的话，就不需要再用 ResponseEntity.status(HttpStatus.CREATED).body(id) 了。
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
