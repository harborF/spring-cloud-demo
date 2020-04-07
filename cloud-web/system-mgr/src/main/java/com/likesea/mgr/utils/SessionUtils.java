package com.likesea.mgr.utils;

import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.LoginUser;
import com.likesea.utils.CommUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class SessionUtils {

    public static LoginUser getLoginUser(HttpSession session) {
        return (LoginUser) session.getAttribute("user");
    }

    public static long getUserId(HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        if (loginUser != null) {
            return loginUser.getUserId();
        }
        return 0;
    }

    public static LoginUser setLoginUser(HttpSession session, AuthorityMember authMember) {
        if ("".equals(CommUtils.null2String(authMember.getUserName()))) {
            return null;
        }
        LoginUser loginUser = new LoginUser();
        {
            loginUser.setUserId(authMember.getUserId());
            loginUser.setUserName(authMember.getUserName());
            loginUser.setUserType(authMember.getUserType());
            loginUser.setNickName(authMember.getNickName());

            loginUser.setLoginTime(new Date());
        }
        session.setAttribute("user", loginUser);
        return loginUser;
    }
}
