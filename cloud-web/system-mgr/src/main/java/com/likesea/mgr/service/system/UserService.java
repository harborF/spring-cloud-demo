package com.likesea.mgr.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
