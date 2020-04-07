package com.likesea.system.mapper;

import com.likesea.system.domain.SysConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemMapper {

    SysConfig selectSysConfigByPKey(int confId);
    List selectSysConfigList(Map params);

    int deleteSysConfigByPKey(Long id);
    int insertSysConfig(SysConfig config)throws Exception;
    int updateSysConfigByPKey(SysConfig config);
    int updateSysConfigSelective(SysConfig config);
}
