package com.likesea.system.controller;

import com.github.pagehelper.PageInfo;
import com.likesea.system.service.SystemServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class SystemController {

    @Autowired
    private SystemServiceI systemService;

    @PostMapping("/querySysConfigList")
    public PageInfo querySysConfigList(@RequestBody Map mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return systemService.querySysConfigList(mParams, pageNo, pageSize);
    }

}
