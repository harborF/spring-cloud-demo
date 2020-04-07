package com.likesea.system.controller;

import com.likesea.system.domain.User;
import com.likesea.system.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uc/")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @GetMapping("/loginByUserName")
    public User loginByUserName(@RequestParam String username, @RequestParam String password) {
        return userService.getUserByUserName(username, password);
    }

    @GetMapping("/loginByMobile")
    public User loginByMobile(@RequestParam String mobile) {
        return userService.getUserByMobile(mobile);
    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) {
        try {
            long newUId = userService.saveUser(user);
            if (newUId > 0) {
                return userService.getUserById(newUId);
            }
        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/unregisterUser")
    public int unregisterUser(@RequestParam long userId) {
        return 0;
    }

    @PostMapping("/registerByWeixin")
    public User registerByWeixin(@RequestBody User user) {
        return null;
    }
}
