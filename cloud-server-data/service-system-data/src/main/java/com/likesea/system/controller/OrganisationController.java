package com.likesea.system.controller;

import com.github.pagehelper.PageInfo;
import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.system.domain.OrgCompany;
import com.likesea.system.domain.OrgDepartment;
import com.likesea.system.domain.OrgEmployee;
import com.likesea.system.domain.OrgPosition;
import com.likesea.system.service.OrganizationServiceI;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/org/")
public class OrganisationController {
    static private final Logger logger = LoggerFactory.getLogger(OrganisationController.class);

    @Autowired
    private OrganizationServiceI orgService;

    @PostMapping("/queryCompanyList")
    public PageInfo queryCompanyList(@RequestBody Map<String, Object> mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return orgService.queryCompanyList(mParams, pageNo, pageSize);
    }

    @GetMapping("/getCompanyById/{cid}")
    public OrgCompany getCompanyById(@PathVariable int cid) {
        return orgService.getCompanyById(cid);
    }

    @PostMapping("/saveCompany")
    public RespEntity saveOrgCompany(@RequestBody OrgCompany company) {
        if (StringUtils.isEmpty(company.getCompanyName())){
            return RespEntity.error(Constants.ERR_PARAM, "公司名不能为空");
        }

        try {
            return RespEntity.success(orgService.saveCompany(company));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryDepartmentList")
    public PageInfo queryDepartmentList(@RequestBody Map<String, Object> mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return orgService.queryDepartmentList(mParams, pageNo, pageSize);
    }

    @GetMapping("/getDepartmentById/{did}")
    public OrgDepartment getDepartmentById(@PathVariable int did) {
        return orgService.getDepartmentByPId(did);
    }

    @PostMapping("/saveDepartment")
    public RespEntity saveOrgDepartment(@RequestBody OrgDepartment depart) {
        if (StringUtils.isEmpty(depart.getDepartName())){
            return RespEntity.error(Constants.ERR_PARAM, "部门名不能为空");
        }

        try {
            return RespEntity.success(orgService.saveDepartment(depart));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryPositionList")
    public PageInfo queryPositionList(@RequestBody Map<String, Object> mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return orgService.queryPositionList(mParams, pageNo, pageSize);
    }

    @GetMapping("/getPositionById/{pid}")
    public OrgPosition getPositionById(@PathVariable int pid) {
        return orgService.getPositionByPId(pid);
    }

    @PostMapping("/savePosition")
    public RespEntity saveOrgPosition(@RequestBody OrgPosition pos) {
        if (StringUtils.isEmpty(pos.getPosName())){
            return RespEntity.error(Constants.ERR_PARAM, "职务名不能为空");
        }

        try {
            return RespEntity.success(orgService.savePosition(pos));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }

    @PostMapping("/queryEmployeeList")
    public PageInfo queryEmployeeList(@RequestBody Map<String, Object> mParams, @RequestParam int pageNo, @RequestParam int pageSize) {
        return orgService.queryEmployeeList(mParams, pageNo, pageSize);
    }

    @GetMapping("/getEmployeeByPId/{eid}")
    public OrgEmployee getEmployeeByPId(@PathVariable int eid) {
        return orgService.getEmployeeByPId(eid);
    }

    @PostMapping("/saveEmployee")
    public RespEntity saveOrgEmployee(@RequestBody OrgEmployee employee) {
        if (StringUtils.isEmpty(employee.getEmployeeName())){
            return RespEntity.error(Constants.ERR_PARAM, "职务名不能为空");
        }

        try {
            return RespEntity.success(orgService.saveEmployee(employee));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return RespEntity.error(Constants.ERR_DUPLICATE);
    }
}
