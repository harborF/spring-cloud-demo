package com.likesea.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.SysConfig;
import com.likesea.system.mapper.SystemMapper;
import com.likesea.system.service.SystemServiceI;
import com.likesea.utils.CommUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SystemServiceImpl implements SystemServiceI {

    @Resource
    private SystemMapper systemMapper;

    @Override
    public SysConfig getSysConfigById(int id) {
        return systemMapper.selectSysConfigByPKey(id);
    }

    @Override
    public PageInfo querySysConfigList(Map params, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo(systemMapper.selectSysConfigList(params));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveSysConfig(SysConfig sysConfig) throws Exception {
        if (CommUtils.null2Int(sysConfig.getCfgId()) > 0){
            return systemMapper.updateSysConfigByPKey(sysConfig);
        }
        return systemMapper.insertSysConfig(sysConfig);
    }
}
