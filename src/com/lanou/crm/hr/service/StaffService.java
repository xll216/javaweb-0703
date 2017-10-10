package com.lanou.crm.hr.service;

import com.lanou.crm.hr.domain.Staff;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface StaffService {
    /**
     * 员工登录
     **/
    Staff login(String name, String psw);

    /**
     * 修改密码
     **/
    boolean updatePwd(Staff staff);

    /**
     * 查询同一个职务的员工
     **/
    List<Staff> querySomeStaff(Staff model);


    /**
     * 查询同一个职务的员工
     **/
    List<Staff> findAll();

    /**
     * 根据id查找某个对象
     **/
    Staff findById(Staff staff);

    /**
     * 更新某个员工信息
     **/
    Staff saveOrUpdate(Staff staff);

}
