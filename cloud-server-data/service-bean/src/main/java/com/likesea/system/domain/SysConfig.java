package com.likesea.system.domain;

import java.util.Date;

public class SysConfig {
    private Integer cfgId;
    private Integer cfgType;
    private String cfgName;
    private Integer cfgLevel;

    private String cfgValue;
    private String cfgDesc;

    private Date updateTime;
    private Date createTime;

    public Integer getCfgId() {
        return cfgId;
    }

    public void setCfgId(Integer cfgId) {
        this.cfgId = cfgId;
    }

    public Integer getCfgType() {
        return cfgType;
    }

    public void setCfgType(Integer cfgType) {
        this.cfgType = cfgType;
    }

    public String getCfgName() {
        return cfgName;
    }

    public void setCfgName(String cfgName) {
        this.cfgName = cfgName;
    }

    public Integer getCfgLevel() {
        return cfgLevel;
    }

    public void setCfgLevel(Integer cfgLevel) {
        this.cfgLevel = cfgLevel;
    }

    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue;
    }

    public String getCfgDesc() {
        return cfgDesc;
    }

    public void setCfgDesc(String cfgDesc) {
        this.cfgDesc = cfgDesc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
