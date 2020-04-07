package com.likesea.mgr.controller.system;

import com.github.pagehelper.PageInfo;
import com.likesea.bean.Constants;
import com.likesea.bean.RespEntity;
import com.likesea.system.domain.OrgCompany;
import com.likesea.system.domain.OrgDepartment;
import com.likesea.system.domain.OrgEmployee;
import com.likesea.system.domain.OrgPosition;
import com.likesea.utils.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 组织结构管理-公司-部门-员工-职务
 **/
@Controller
@RequestMapping("/crm/")
public class OrganisationController {
    @Autowired
    protected RestTemplate restTemplate;

    @RequestMapping("/employee-list")
    public String employeeList(Map reqParams, ModelMap modelMap) {
        int pageNo = CommUtils.param2Int(reqParams,"pageNo");
        int pageSize = CommUtils.param2Int(reqParams, "pageSize");
        ResponseEntity<PageInfo<OrgEmployee>> result = restTemplate.exchange("http://system-data/org/queryEmployeeList?pageNo={pageNo}&pageSize={pageSize}",
                HttpMethod.POST, new HttpEntity(reqParams),
                new ParameterizedTypeReference<PageInfo<OrgEmployee>>() {
                }, pageNo, pageSize);
        PageInfo<OrgEmployee> pageInfo = result.getBody();

        modelMap.put("userList", pageInfo.getList());
        pageInfo.setList(null);
        modelMap.put("pageInfo", pageInfo);

        return "organization/employee-list";
    }

    @RequestMapping(value="/employee-edit", method = RequestMethod.GET)
    public String employeeEdit(Integer id, ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "organization/employee-edit";
    }

    @RequestMapping(value = "/employee-save", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity employeeSave(@RequestBody OrgEmployee employee) {


        return RespEntity.success();
    }

    @RequestMapping("/organization-list")
    public String organizationList(Map reqParams, ModelMap modelMap) {
        int pageNo = CommUtils.param2Int(reqParams,"pageNo");
        int pageSize = CommUtils.param2Int(reqParams, "pageSize");
        ResponseEntity<PageInfo<OrgDepartment>> result = restTemplate.exchange("http://system-data/org/queryDepartmentList?pageNo={pageNo}&pageSize={pageSize}",
                HttpMethod.POST, new HttpEntity(reqParams),
                new ParameterizedTypeReference<PageInfo<OrgDepartment>>() {
                }, pageNo, pageSize);
        PageInfo<OrgDepartment> pageInfo = result.getBody();

        modelMap.put("userList", pageInfo.getList());
        pageInfo.setList(null);
        modelMap.put("pageInfo", pageInfo);

        return "organization/structure";
    }

    @RequestMapping(value ="/organization-tree", produces="application/json;charset=UTF-8")
    @ResponseBody
    public RespEntity organizationTree() {
        ResponseEntity<PageInfo<OrgDepartment>> result = restTemplate.exchange("http://system-data/org/queryDepartmentList?pageNo=0&pageSize=0",
                HttpMethod.POST, new HttpEntity(Constants.EMPTY_PARAM),
                new ParameterizedTypeReference<PageInfo<OrgDepartment>>() {
                });
        PageInfo<OrgDepartment> pageInfo = result.getBody();

        return RespEntity.success(pageInfo.getList());
    }

    @RequestMapping(value="/company-edit", method = RequestMethod.GET)
    public String companyEdit(Integer id, ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "organization/department-edit";
    }

    @RequestMapping(value = "/company-save", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity companySave(@RequestBody OrgCompany company) {

        return RespEntity.success();
    }

    @RequestMapping(value="/department-edit", method = RequestMethod.GET)
    public String departmentEdit(Integer id, ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "organization/department-edit";
    }

    @RequestMapping(value = "/department-save", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity departmentSave(@RequestBody OrgDepartment department) {

        return RespEntity.success();
    }

    @RequestMapping("/position-list")
    public String positionList(Map reqParams, ModelMap modelMap) {
        int pageNo = CommUtils.param2Int(reqParams,"pageNo");
        int pageSize = CommUtils.param2Int(reqParams, "pageSize");
        ResponseEntity<PageInfo<OrgPosition>> result = restTemplate.exchange("http://system-data/org/queryPositionList?pageNo={pageNo}&pageSize={pageSize}",
                HttpMethod.POST, new HttpEntity(reqParams),
                new ParameterizedTypeReference<PageInfo<OrgPosition>>() {
                }, pageNo, pageSize);
        PageInfo<OrgPosition> pageInfo = result.getBody();

        modelMap.put("posList", pageInfo.getList());
        pageInfo.setList(null);
        modelMap.put("pageInfo", pageInfo);

        return "organization/position-list";
    }

    @RequestMapping(value="/position-edit", method = RequestMethod.GET)
    public String positionEdit(Integer id, ModelMap modelMap) {
        modelMap.put("name", "Joe");

        return "organization/position-edit";
    }

    @RequestMapping(value = "/position-save", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity positionSave(@RequestBody OrgPosition position) {

        return RespEntity.success();
    }
}
