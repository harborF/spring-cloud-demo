package com.likesea.system.service;

import com.likesea.system.domain.AuthorityResource;

import java.util.List;
import java.util.Map;

public interface PermissionServiceI {

    List queryPermissionList(Map mParam);
    int savePermission(AuthorityResource authPerm)throws Exception;

    AuthorityResource getMenuByPId(int menuId);
    List queryMenuList(Map mParam);
    int saveMenu(AuthorityResource authMenu)throws Exception;

    List queryAuthResByRId(int roleId, int type);
    int saveAuthResByRId(int roleId, int type, List<AuthorityResource> listAuthRes);
}
