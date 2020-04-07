package com.likesea.system.mapper;

import com.likesea.system.domain.OrgCompany;
import com.likesea.system.domain.OrgDepartment;
import com.likesea.system.domain.OrgEmployee;
import com.likesea.system.domain.OrgPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrganizationMapper {

    List selectEmployeeList(Map mParam);
    OrgEmployee selectEmployeeByPKey(Integer id);

    int deleteEmployeeByPKey(Integer id);
    int insertEmployee(OrgEmployee employee)throws Exception;
    int updateEmployee(OrgEmployee employee);

    /**公司*/
    List selectCompanyList(Map mParam);
    OrgCompany selectCompanyByPId(int companyId);

    int insertCompany(OrgCompany company)throws Exception;
    int updateCompany(OrgCompany company);
    int deleteCompanyByPKey(int companyId);

    /**部门*/
    List selectDepartmentList(Map mParam);
    OrgDepartment selectDepartmentByPId(int departId);

    int insertDepartment(OrgDepartment depart)throws Exception;
    int updateDepartment(OrgDepartment depart);
    int deleteDepartmentByPId(int departId);

    /**职务*/
    List selectPositionList(Map mParam);
    OrgPosition selectPositionByPId(int posId);

    int insertPosition(OrgPosition pos)throws Exception;
    int updatePosition(OrgPosition pos);
    int deletePositionByPId(int posId);
}
