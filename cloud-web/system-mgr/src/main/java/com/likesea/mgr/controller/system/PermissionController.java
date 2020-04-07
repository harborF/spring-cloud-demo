package com.likesea.mgr.controller.system;

import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.mgr.service.system.AdminService;
import com.likesea.mgr.service.system.AuthorService;
import com.likesea.system.domain.AuthorityResource;
import com.likesea.utils.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统权限管理
 **/
@Controller
@RequestMapping("/admin/")
public class PermissionController {

    @Autowired
    private AuthorService permService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/menu-list")
    public String adminMenuList() {
        return "admin/menu-list";
    }

    @RequestMapping(value ="/menu-tree", produces="application/json;charset=UTF-8")
    @ResponseBody
    public RespEntity adminMenuTree(String type) {
        if("perm".equals(type)){
            return RespEntity.success(permService.queryPermissionList(Constants.EMPTY_PARAM));
        }

        return RespEntity.success(permService.queryMenuList(Constants.EMPTY_PARAM));
    }

    @RequestMapping("/menu-edit")
    public String adminMenuEdit(Integer id, ModelMap modelMap) {
        if (id != null){
            modelMap.put("vo", permService.getMenuByMId(id));
            Map params = new HashMap<>(1);
            params.put("parentId", 0);
            modelMap.put("menuList", permService.queryMenuList(params));
            modelMap.put("appList", adminService.queryAppList(Constants.EMPTY_PARAM));
        }

        return "admin/menu-edit";
    }

    @RequestMapping("/menu-save")
    @ResponseBody
    public RespEntity adminMenuSave(@RequestBody AuthorityResource authRes) {
        if (StringUtils.isEmpty(authRes.getResTitle())){
            return RespEntity.error(Constants.ERR_PARAM, "菜单名不能为空");
        }
        if (StringUtils.isEmpty(authRes.getResUrl())){
            return RespEntity.error(Constants.ERR_PARAM, "菜单地址不能为空");
        }
        permService.saveMenu(authRes);

        return RespEntity.success();
    }

    @RequestMapping("/perm-list")
    public String adminPermission(ModelMap modelMap) {
        List<AuthorityResource> permList = permService.queryPermissionList(Constants.EMPTY_PARAM);
        modelMap.put("permList", permList);

        return "admin/permission";
    }

    @RequestMapping("/perm-edit")
    public String adminPermEdit(Integer id, ModelMap modelMap) {
        if(id != null){

        }

        modelMap.put("name", "Joe");

        return "admin/perm-edit";
    }

    @PostMapping("/perm-save")
    @ResponseBody
    public RespEntity adminPermSave(@RequestBody AuthorityResource authPerm) {
        if (StringUtils.isEmpty(authPerm.getResTitle())){
            return RespEntity.error(-1, "权限名不能为空");
        }
        if (StringUtils.isEmpty(authPerm.getResUrl())){
            return RespEntity.error(-1, "权限地址不能为空");
        }
        permService.saveMenu(authPerm);

        return RespEntity.success();
    }

    @RequestMapping("/assign-menu")
    public String adminRoleAssignMenu(ModelMap modelMap) {
        modelMap.put("menuList", SystemUtils.menuTree(permService.queryAuthResByRId(200, 1)));

        return "admin/assign-menu";
    }

    @PostMapping("/assign-menu-save")
    @ResponseBody
    public RespEntity adminAssignMenuSave(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return RespEntity.success();
    }

    @RequestMapping("/assign-perms")
    public String adminRoleAssignPerms(ModelMap modelMap) {
        modelMap.put("permList", SystemUtils.menuTree(permService.queryAuthResByRId(200, 2)));

        return "admin/assign-perms";
    }

    @PostMapping("/assign-perm-save")
    @ResponseBody
    public RespEntity adminAssignPermSave(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return RespEntity.success();
    }
}
