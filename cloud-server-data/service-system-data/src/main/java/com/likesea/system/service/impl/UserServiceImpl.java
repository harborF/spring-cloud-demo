package com.likesea.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.likesea.system.service.UserServiceI;
import com.likesea.system.domain.User;
import com.likesea.system.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        return userMapper.selectByPKey(id);
    }

    @Override
    public User getUserByMobile(String mobile){
        Map mParams = new HashMap();
        mParams.put("mobile", mobile);
        List<User> userList = userMapper.selectUserList(mParams);
        if (userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserByUserName(String userName, String password){
        Map mParams = new HashMap();
        {
            mParams.put("userName", userName);
            mParams.put("password", password);
        }
        List<User> userList = userMapper.selectUserList(mParams);
        if (userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List queryUserList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.selectUserList(mParams);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long saveUser(User user) throws Exception {
        if (user.getUserId() != null && user.getUserId() > 0){
            return userMapper.updateUserSelective(user);
        }
        return userMapper.insertUser(user);
    }
}
