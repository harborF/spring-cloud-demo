package com.likesea.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likesea.system.service.OrganizationServiceI;
import com.likesea.system.domain.OrgCompany;
import com.likesea.system.domain.OrgDepartment;
import com.likesea.system.domain.OrgEmployee;
import com.likesea.system.domain.OrgPosition;
import com.likesea.system.mapper.OrganizationMapper;
import com.likesea.utils.CommUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class OrganizationServiceImpl implements OrganizationServiceI {

    @Resource
    private OrganizationMapper organizeMapper;

    @Override
    public OrgCompany getCompanyById(Integer id) {
        return organizeMapper.selectCompanyByPId(id);
    }

    @Override
    public PageInfo queryCompanyList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(organizeMapper.selectCompanyList(mParams));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveCompany(OrgCompany company)throws Exception {
        if (CommUtils.null2Int(company.getCompanyId()) > 0) {
            return organizeMapper.updateCompany(company);
        }
        return organizeMapper.insertCompany(company);
    }

    @Override
    public OrgEmployee getEmployeeByPId(int employeeId) {
        return organizeMapper.selectEmployeeByPKey(employeeId);
    }

    @Override
    public PageInfo queryEmployeeList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(organizeMapper.selectEmployeeList(mParams));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveEmployee(OrgEmployee employee) throws Exception{
        if (CommUtils.null2Int(employee.getEmployeeId()) > 0) {
            return organizeMapper.updateEmployee(employee);
        }
        return organizeMapper.insertEmployee(employee);
    }

    @Override
    public OrgDepartment getDepartmentByPId(int departId) {
        return organizeMapper.selectDepartmentByPId(departId);
    }

    @Override
    public PageInfo queryDepartmentList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(organizeMapper.selectDepartmentList(mParams));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveDepartment(OrgDepartment department)throws Exception {
        if (CommUtils.null2Int(department.getDepartId()) > 0) {
            return organizeMapper.updateDepartment(department);
        }
        return organizeMapper.insertDepartment(department);
    }

    @Override
    public OrgPosition getPositionByPId(int posId) {
        return organizeMapper.selectPositionByPId(posId);
    }

    @Override
    public PageInfo queryPositionList(Map mParams, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(organizeMapper.selectPositionList(mParams));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int savePosition(OrgPosition position)throws Exception {
        if (CommUtils.null2Int(position.getPosId()) > 0) {
            return organizeMapper.updatePosition(position);
        }
        return organizeMapper.insertPosition(position);
    }
}
