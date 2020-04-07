package com.demo.feign.controller;

import com.demo.feign.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceI userService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return userService.hiService(name);
    }
}
