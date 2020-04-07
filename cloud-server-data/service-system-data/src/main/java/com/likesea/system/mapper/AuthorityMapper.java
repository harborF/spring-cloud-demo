package com.likesea.system.mapper;

import com.likesea.system.domain.AuthorityResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorityMapper {

    /**权限*菜单*/
    AuthorityResource getAuthResByPId(int resId);
    List selectPermissionList(Map map);
    List selectMenuList(Map map);

    int insertAuthRes(AuthorityResource authRes)throws Exception;
    int updateAuthRes(AuthorityResource authRes);
    int deleteResByPKey(int id);

    /***/
    List selectAuthResByRId(int roleId);
    int deleteMenuByRId(int roleId);
    int deletePermByRId(int roleId);
    int insertRoleAuthRes(List<AuthorityResource> authResList)throws Exception;
}
