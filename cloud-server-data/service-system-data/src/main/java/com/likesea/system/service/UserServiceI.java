package com.likesea.system.service;

import com.likesea.system.domain.User;

import java.util.List;
import java.util.Map;

public interface UserServiceI {

    User getUserById(long id);
    User getUserByMobile(String mobile);
    User getUserByUserName(String userName, String password);

    List queryUserList(Map mParams, int pageNo, int pageSize);

    long saveUser(User user) throws Exception;
}

