package com.likesea.system.service;

import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.SysConfig;

import java.util.Map;

public interface SystemServiceI {

    SysConfig getSysConfigById(int id);
    PageInfo querySysConfigList(Map params, int pageNo, int pageSize);
    int saveSysConfig(SysConfig sysConfig)throws Exception;
}
