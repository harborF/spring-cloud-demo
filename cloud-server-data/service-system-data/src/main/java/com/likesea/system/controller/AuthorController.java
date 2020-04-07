package com.likesea.system.controller;

import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.system.domain.AuthorityResource;
import com.likesea.system.service.PermissionServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class AuthorController {
    static private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private PermissionServiceI permissionService;

    @PostMapping("/queryMenuList")
    public List<AuthorityResource> queryMenuList(@RequestBody Map mParams){
        return permissionService.queryMenuList(mParams);
    }

    @GetMapping("/getMenuByMId/{menuId}")
    public AuthorityResource getMenuByMId(@PathVariable int menuId) {
        return permissionService.getMenuByPId(menuId);
    }

    @GetMapping("/getMenuByUId/{userId}")
    public List<AuthorityResource> getMenuByUId(@PathVariable int userId) {
        Map mParams = new HashMap();
        mParams.put("userId", userId);
        return permissionService.queryMenuList(mParams);
    }

    @PostMapping("/saveMenu")
    public RespEntity saveMenu(@RequestBody AuthorityResource authRes){
        try {
            int menuId = permissionService.saveMenu(authRes);
            return RespEntity.success(menuId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryPermissionList")
    public List<AuthorityResource> queryPermissionList(@RequestBody Map mParams){
        return permissionService.queryPermissionList(mParams);
    }

    @GetMapping("/queryAuthResByRId")
    public List queryAuthResByRId(@RequestParam int roleId, @RequestParam int type){
        return permissionService.queryAuthResByRId(roleId, type);
    }
}
