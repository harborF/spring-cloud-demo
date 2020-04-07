package com.likesea.mgr.controller.system;

import com.likesea.mgr.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会员管理
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String userLogin(@RequestBody ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "index";
    }

    @RequestMapping("/logout")
    public String userLogout(@RequestBody ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "index";
    }
}
