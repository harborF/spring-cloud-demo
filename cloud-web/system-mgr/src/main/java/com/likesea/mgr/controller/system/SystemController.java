package com.likesea.mgr.controller.system;

import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.SysConfig;
import com.likesea.utils.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 系统管理
 **/
@Controller
@RequestMapping("/sys")
public class SystemController {
    @Autowired
    protected RestTemplate restTemplate;

    @RequestMapping("/config-list")
    public String sysConfigList(Map reqParams, ModelMap modelMap) {
        int pageNo = CommUtils.param2Int(reqParams,"pageNo");
        int pageSize = CommUtils.param2Int(reqParams, "pageSize");

        ResponseEntity<PageInfo<SysConfig>> result = restTemplate.exchange("http://system-data/admin/querySysConfigList?pageNo={pageNo}&pageSize={pageSize}",
                HttpMethod.POST, new HttpEntity(reqParams),
                new ParameterizedTypeReference<PageInfo<SysConfig>>() {
                }, pageNo, pageSize);

        PageInfo<SysConfig> adminPage = result.getBody();
        modelMap.put("confList", adminPage.getList());

        return "system/config-list";
    }

    @RequestMapping("/cache-list")
    public String sysCacheList(ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "system/cache-list";
    }
}
