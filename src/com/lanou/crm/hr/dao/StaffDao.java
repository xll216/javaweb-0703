package com.lanou.crm.hr.dao;

import com.lanou.crm.base.BaseDao;
import com.lanou.crm.hr.domain.Staff;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface StaffDao extends BaseDao<Staff> {
    /**
     * 登录 -- 查询用户信息是否正确
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    Staff find(String loginName, String loginPwd);

    /**
     * 查找同一职务的员工
     **/
    List<Staff> querySomeStaff(Staff model);
}
