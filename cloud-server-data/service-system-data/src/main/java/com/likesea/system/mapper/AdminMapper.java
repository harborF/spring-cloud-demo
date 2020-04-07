package com.likesea.system.mapper;

import com.likesea.system.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {

    List selectAuthMemberList(Map mParam);
    AuthorityMember selectAuthMemberByPKey(Long uid);

    int insertAuthMember(AuthorityMember authMember)throws Exception;
    int updateAuthMemberByPKey(AuthorityMember authMember);
    int updateAuthMemberSelective(AuthorityMember authMember);
    int deleteAuthMemberByPKey(Long uid);

    /**角色*/
    AuthorityRole getRoleByPId(int roleId);
    List selectRoleList(Map map);

    int insertRole(AuthorityRole authRole)throws Exception;
    int updateRoleByPKey(AuthorityRole authRole);
    int deleteRoleByPKey(int rid);

    /***/
    int insertUserRole(List<AuthorityRole> userRoleList)throws Exception;
    int deleteUserRole(int userId);

    /**模块*/
    AuthorityApp getAppByPId(int appId);
    List selectAppList(Map map);

    int insertApp(AuthorityApp authApp)throws Exception;
    int updateAppByPKey(AuthorityApp authApp);
    int deleteAppByPKey(int aid);
}
