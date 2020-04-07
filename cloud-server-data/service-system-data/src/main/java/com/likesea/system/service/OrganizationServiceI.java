package com.likesea.system.service;

import com.github.pagehelper.PageInfo;
import com.likesea.system.domain.*;


import java.util.Map;

public interface OrganizationServiceI {

    OrgCompany getCompanyById(Integer id);
    PageInfo queryCompanyList(Map mParams, int pageNo, int pageSize);
    int saveCompany(OrgCompany company)throws Exception;

    OrgEmployee getEmployeeByPId(int employeeId);
    PageInfo queryEmployeeList(Map mParams, int pageNo, int pageSize);
    int saveEmployee(OrgEmployee employee)throws Exception;

    OrgDepartment getDepartmentByPId(int departId);
    PageInfo queryDepartmentList(Map mParams, int pageNo, int pageSize);
    int saveDepartment(OrgDepartment department)throws Exception;

    OrgPosition getPositionByPId(int posId);
    PageInfo queryPositionList(Map mParams, int pageNo, int pageSize);
    int savePosition(OrgPosition position)throws Exception;
}
