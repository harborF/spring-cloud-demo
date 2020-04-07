package com.likesea.system.service;

import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.AuthorityRole;

import java.util.List;
import java.util.Map;

public interface AdminServiceI {

    AuthorityMember getMemberByName(String memberName, String password);

    AuthorityMember getUserById(long id);
    PageInfo queryUserList(Map mParams, int pageNo, int pageSize);
    int saveAuthMember(AuthorityMember authMember)throws Exception;

    AuthorityRole getRoleByRId(int roleId);
    List queryRoleList(Map mParam);
    int saveAuthRole(AuthorityRole role)throws Exception;

    AuthorityApp getAppByAId(int appId);
    List queryAppList(Map mParam);
    int saveApp(AuthorityApp app) throws Exception;
}
