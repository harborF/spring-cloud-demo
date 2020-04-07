package com.likesea.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ServiceProxyBase {

    @Autowired
    protected RestTemplate restTemplate;
}
