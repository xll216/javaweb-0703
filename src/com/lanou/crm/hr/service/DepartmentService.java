package com.lanou.crm.hr.service;

import com.lanou.crm.hr.domain.Department;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface DepartmentService {
    List<Department> findAllDepartment();

    Department findById(Department department);
}
