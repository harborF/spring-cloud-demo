package com.likesea.mgr.controller.system;

import com.github.pagehelper.PageInfo;
import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.mgr.service.system.AdminService;
import com.likesea.mgr.utils.SessionUtils;
import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.AuthorityRole;
import com.likesea.system.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 系统管理员管理
 **/
@Controller
@RequestMapping("/admin/")
public class AdminController {
    static private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public String adminList(ModelMap modelMap) {

        PageInfo<User> adminPage = adminService.queryMemberList(new HashMap(), 0 , 10);
        modelMap.put("userList", adminPage.getList());
        adminPage.setList(null);
        modelMap.put("pageInfo", adminPage);

        return "admin/admin-list";
    }

    @RequestMapping("/show")
    public String adminShow(HttpSession session, ModelMap modelMap) {
        AuthorityMember authUser = adminService.getMemberById(SessionUtils.getUserId(session));
        if (authUser == null){
            modelMap.put("user", authUser);
        }

        return "admin/show";
    }

    @RequestMapping(value="/admin-edit", method = RequestMethod.GET)
    public String adminEdit(@RequestParam(value="id", required = false) Integer id, ModelMap modelMap) {
        if(id != null){
            modelMap.put("user", adminService.getMemberById(id));
        }
        modelMap.put("roleList", adminService.queryRoleList(Constants.EMPTY_PARAM));

        return "admin/admin-edit";
    }

    @PostMapping("/admin-save")
    @ResponseBody
    public RespEntity adminAuthMemberSave(@RequestBody AuthorityMember AuthMember) {
        if (StringUtils.isEmpty(AuthMember.getUserName())){
            return RespEntity.error(-1, "用户名不能为空");
        }
        return adminService.saveAuthMember(AuthMember);
    }

    @RequestMapping("/role-list")
    public String adminRoleList(ModelMap modelMap) {

        modelMap.put("roleList", adminService.queryRoleList(Constants.EMPTY_PARAM));

        return "admin/role-list";
    }

    @RequestMapping("/role-edit")
    public String adminRoleEdit(@RequestParam(value="id", required = false) Integer id, ModelMap modelMap) {
        if (id != null){
            modelMap.put("role", adminService.getRoleById(id));
        }

        return "admin/role-edit";
    }

    @PostMapping("/role-save")
    @ResponseBody
    public RespEntity adminRoleSave(@RequestBody AuthorityRole authRole) {
        if (StringUtils.isEmpty(authRole.getRoleName())){
            return RespEntity.error(-1, "角色名不能为空");
        }
        return adminService.saveAuthRole(authRole);
    }

    @RequestMapping("/app-list")
    public String adminAppList(ModelMap modelMap) {
        List appList = adminService.queryAppList(Constants.EMPTY_PARAM);
        modelMap.put("appList", appList);

        return "admin/app-list";
    }

    @RequestMapping("/app-edit")
    public String adminAppEdit(Integer id, ModelMap modelMap) {
        if(id != null){
            modelMap.put("app", adminService.getAppById(id));
        }

        return "admin/app-edit";
    }

    @PostMapping("/app-save")
    @ResponseBody
    public RespEntity adminAppSave(@RequestBody AuthorityApp authApp) {
        if (StringUtils.isEmpty(authApp.getAppName())){
            return RespEntity.error(-1, "模块名不能为空");
        }
        RespEntity res = adminService.saveApp(authApp);
        if (res.getCode() != 0){
            logger.error("failed to save app info");
        }

        return RespEntity.success();
    }
}
