package com.likesea.utils;


import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityResource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemUtils {
    public static List appMenuTree(List<AuthorityResource> lstMenus) {

        List<AuthorityApp> appMenuTree = new ArrayList();
        Iterator<AuthorityResource> it = lstMenus.iterator();
        while (it.hasNext()) {
            AuthorityResource res = it.next();
            if (0 == res.getParentId()) {
                AuthorityApp newApp = null;
                for(AuthorityApp app : appMenuTree){
                    if(app.getAppId()==res.getAppId()){
                        newApp = app;
                        break;
                    }
                }

                if (newApp == null){
                    newApp = new AuthorityApp();
                    newApp.setAppId(res.getAppId());
                    newApp.setAppName(res.getAppName());
                    newApp.setChildrenRes(new ArrayList());
                    appMenuTree.add(newApp);
                }
                List subMenuList = getChildMenu(res.getTreeId(), lstMenus);
                if (subMenuList != null){
                    res.setChildrenRes(subMenuList);
                    newApp.getChildrenRes().add(res);
                }
                it.remove();
            }
        }

        return appMenuTree;
    }

    public static List menuTree(List<AuthorityResource> lstMenus) {

        List menuTree = new ArrayList();
        Iterator<AuthorityResource> it = lstMenus.iterator();
        while (it.hasNext()) {
            AuthorityResource res = it.next();
            if (0 == res.getParentId()) {
                List subMenuList = getChildMenu(res.getTreeId(), lstMenus);
                if (subMenuList != null){
                    res.setChildrenRes(subMenuList);
                }
                menuTree.add(res);
            }
        }

        return menuTree;
    }

    private static List<AuthorityResource> getChildMenu(Integer id, List<AuthorityResource> allMenu){

        List<AuthorityResource> childList = new ArrayList<>();
        for (AuthorityResource subMenu : allMenu) {
            if(id.equals(subMenu.getParentId())){
                childList.add(subMenu);
            }
        }

        for (AuthorityResource subMenu : childList) {
            List subMenuList = getChildMenu(subMenu.getTreeId(), allMenu);
            if (subMenuList != null){
                subMenu.setChildrenRes(subMenuList);
            }
        }
        if(childList.size() == 0){
            return null;
        }
        return childList;
    }
}
