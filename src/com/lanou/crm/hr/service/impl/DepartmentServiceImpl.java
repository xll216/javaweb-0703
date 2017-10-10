package com.lanou.crm.hr.service.impl;

import com.lanou.crm.hr.dao.DepartmentDao;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Qualifier("departmentDao")
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Department findById(Department department) {
        return departmentDao.findById(department.getDepID());
    }
}
