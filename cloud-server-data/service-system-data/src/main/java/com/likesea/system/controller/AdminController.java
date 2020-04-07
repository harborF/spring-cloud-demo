package com.likesea.system.controller;

import com.github.pagehelper.PageInfo;
import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.AuthorityRole;
import com.likesea.system.service.AdminServiceI;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    static private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminServiceI adminService;

    @GetMapping("/loginByMemberName")
    public AuthorityMember loginByMemberName(@RequestParam String username, @RequestParam String password) {
        return adminService.getMemberByName(username, password);
    }

    @PostMapping("/queryMemberList")
    public PageInfo queryMemberList(@RequestBody Map<String, Object> mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return adminService.queryUserList(mParams, pageNo, pageSize);
    }

    @GetMapping("/getMemberById/{uid}")
    public AuthorityMember getMemberById(@PathVariable long uid) {
        return adminService.getUserById(uid);
    }

    @PostMapping("/saveAuthMember")
    public RespEntity saveAuthMember(@RequestBody AuthorityMember authMember) {
        if (StringUtils.isEmpty(authMember.getUserName())){
            return RespEntity.error(Constants.ERR_PARAM, "用户名不能为空");
        }

        try {
            return RespEntity.success(adminService.saveAuthMember(authMember));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryRoleList")
    public List<AuthorityRole> queryRoleList(@RequestBody Map mParams) {
        return adminService.queryRoleList(mParams);
    }

    @GetMapping("/getRoleById/{rid}")
    public AuthorityRole getRoleById(@PathVariable int rid) {
        return adminService.getRoleByRId(rid);
    }

    @PostMapping("/saveAuthRole")
    public RespEntity saveAuthRole(@RequestBody AuthorityRole authRole) {
        if (StringUtils.isEmpty(authRole.getRoleName())){
            return RespEntity.error(Constants.ERR_PARAM, "角色名不能为空");
        }

        try {
            return RespEntity.success(adminService.saveAuthRole(authRole));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryAppList")
    public List<AuthorityApp> queryAppList(@RequestBody Map mParams) {
        return adminService.queryAppList(mParams);
    }

    @GetMapping("/getAppById/{aid}")
    public AuthorityApp getAppById(@PathVariable int aid) {
        return adminService.getAppByAId(aid);
    }

    @PostMapping("/saveApp")
    public RespEntity saveApp(@RequestBody AuthorityApp authApp) {
        if (StringUtils.isEmpty(authApp.getAppName())){
            return RespEntity.error(Constants.ERR_PARAM, "模块名不能为空");
        }

        try {
            return RespEntity.success(adminService.saveApp(authApp));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }
}
