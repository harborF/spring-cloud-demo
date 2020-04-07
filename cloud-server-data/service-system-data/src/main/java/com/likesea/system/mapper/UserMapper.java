package com.likesea.system.mapper;

import com.likesea.system.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List selectUserList(Map mParam);
    User selectByPKey(Long id);

    int deleteByPKey(Long id);
    long insertUser(User user) throws Exception;

    int updateUserByPKey(User user) throws Exception;
    int updateUserSelective(User user) throws Exception;
}
