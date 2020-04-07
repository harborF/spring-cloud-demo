package com.likesea.system.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class AuthorityApp {
    private Integer appId;

    @NotBlank(message = "模块名不能为空")
    private String appName;
    private String appType;
    private String serviceId;

    private Date createTime;
    private Long createUid;

    private List childrenRes;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List getChildrenRes() {
        return childrenRes;
    }

    public void setChildrenRes(List childrenRes) {
        this.childrenRes = childrenRes;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }
}
