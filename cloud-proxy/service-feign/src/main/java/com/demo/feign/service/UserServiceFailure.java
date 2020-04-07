package com.demo.feign.service;

import org.springframework.stereotype.Component;

@Component//Feign断路器
public class UserServiceFailure implements UserServiceI {

    @Override
    public String hiService(String name){
        return "hello world service is not available !";
    }
}
