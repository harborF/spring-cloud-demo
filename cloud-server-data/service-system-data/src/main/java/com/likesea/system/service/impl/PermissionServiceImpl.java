package com.likesea.system.service.impl;

import com.likesea.system.domain.AuthorityResource;
import com.likesea.system.mapper.AuthorityMapper;
import com.likesea.system.service.PermissionServiceI;
import com.likesea.utils.CommUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionServiceI {

    @Resource
    private AuthorityMapper authorityMapper;

    @Override
    public List queryPermissionList(Map mParam) {
        return authorityMapper.selectPermissionList(mParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int savePermission(AuthorityResource authPerm)throws Exception {
        if (CommUtils.null2Int(authPerm.getTreeId()) > 0){
            return authorityMapper.updateAuthRes(authPerm);
        }
        return authorityMapper.insertAuthRes(authPerm);
    }

    @Override
    public AuthorityResource getMenuByPId(int menuId) {
        return authorityMapper.getAuthResByPId(menuId);
    }

    @Override
    public List queryMenuList(Map mParam) {
        return authorityMapper.selectMenuList(mParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveMenu(AuthorityResource authMenu) throws Exception{
        if (CommUtils.null2Int(authMenu.getTreeId()) > 0){
            return authorityMapper.updateAuthRes(authMenu);
        }
        return authorityMapper.insertAuthRes(authMenu);
    }

    @Override
    public List<AuthorityResource> queryAuthResByRId(int roleId, int type) {
        return authorityMapper.selectAuthResByRId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveAuthResByRId(int roleId, int type, List<AuthorityResource> listAuthRes) {
        return 0;
    }

}
