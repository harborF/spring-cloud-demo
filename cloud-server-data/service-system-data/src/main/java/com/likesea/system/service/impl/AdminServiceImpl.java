package com.likesea.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.AuthorityRole;
import com.likesea.system.mapper.AdminMapper;
import com.likesea.system.service.AdminServiceI;
import com.likesea.utils.CommUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminServiceI {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public AuthorityMember getMemberByName(String memberName, String password) {
        Map params = new HashMap(2);
        {
            params.put("userName", memberName);
            params.put("password", password);
        }

        List<AuthorityMember> memberList = adminMapper.selectAuthMemberList(params);
        if (memberList.size() == 0){
            return null;
        }

        return memberList.get(0);
    }

    @Override
    public AuthorityMember getUserById(long id) {
        return adminMapper.selectAuthMemberByPKey(id);
    }

    @Override
    public PageInfo<AuthorityMember> queryUserList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(adminMapper.selectAuthMemberList(mParams));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveAuthMember(AuthorityMember authMember)throws Exception{
        if (CommUtils.null2Long(authMember.getUserId()) > 0){
            return adminMapper.updateAuthMemberByPKey(authMember);
        }
        return adminMapper.insertAuthMember(authMember);
    }

    @Override
    public AuthorityRole getRoleByRId(int roleId) {
        return adminMapper.getRoleByPId(roleId);
    }

    @Override
    public List queryRoleList(Map mParam) {
        return adminMapper.selectRoleList(mParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveAuthRole(AuthorityRole authRole)throws Exception {
        if (CommUtils.null2Int(authRole.getRoleId()) > 0) {
            return adminMapper.updateRoleByPKey(authRole);
        }
        return adminMapper.insertRole(authRole);
    }

    @Override
    public AuthorityApp getAppByAId(int appId) {
        return adminMapper.getAppByPId(appId);
    }

    @Override
    public List queryAppList(Map mParam) {
        return adminMapper.selectAppList(mParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveApp(AuthorityApp authApp) throws Exception{
        if (CommUtils.null2Int(authApp.getAppId()) > 0){
            return adminMapper.updateAppByPKey(authApp);
        }
        return adminMapper.insertApp(authApp);
    }
}
