package com.likesea.mgr.controller.system;

import com.likesea.bean.RespEntity;
import com.likesea.mgr.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员管理
 **/
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String memberList(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "member/list";
    }

    @RequestMapping("/show")
    public String memberShow(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "member/show";
    }

    @RequestMapping("/edit")
    public String memberEdit(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "member/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public RespEntity memberSave(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return RespEntity.success();
    }
}
