package com.likesea.mgr.controller.system;

import com.likesea.bean.Constants;
import com.likesea.mgr.service.system.AdminService;
import com.likesea.mgr.service.system.AuthorService;
import com.likesea.mgr.utils.SessionUtils;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.LoginUser;
import com.likesea.utils.CommUtils;
import com.likesea.utils.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    static private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private AuthorService permService;

    @RequestMapping("/admin")
    public String admin(HttpSession session, ModelMap modelMap) {
        LoginUser loginUser = SessionUtils.getLoginUser(session);
        if (loginUser == null) {
            return "redirect:login.html";
        }
        modelMap.put("appMenuList", SystemUtils.appMenuTree(permService.queryMenuList(Constants.EMPTY_PARAM)));

        return "admin";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, ModelMap modelMap) {
        LoginUser loginUser = SessionUtils.getLoginUser(session);
        if (loginUser == null) {
            return "redirect:login.html";
        }
        modelMap.put("user", loginUser);
        Map reqParams = new HashMap<>(1);
        {
            reqParams.put("userId", loginUser.getUserId());
        }
        modelMap.put("appMenuList", SystemUtils.appMenuTree(permService.queryMenuList(reqParams)));

        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String userName, String password, ModelMap modelMap) {
        if (!"".equals(CommUtils.null2String(userName)) && !"".equals(CommUtils.null2String(password))) {
            AuthorityMember member = adminService.loginByMemberName(userName, password);
            if (member != null) {
                modelMap.put("user", SessionUtils.setLoginUser(session, member));

                return "redirect:index.html";
            }
        }
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "welcome";
    }
}
