package com.lanou.crm.hr.service.impl;

import com.lanou.crm.hr.dao.StaffDao;
import com.lanou.crm.hr.domain.Staff;
import com.lanou.crm.hr.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Qualifier("staffDao")
    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff login(String name, String psw) {
        /*登录查找，找到返回当前登录对象，否则返回null*/
        return staffDao.find(name, psw);
    }

    /**
     * 修改密码
     **/
    @Override
    public boolean updatePwd(Staff staff) {
        System.out.println(staff);
        return true;
    }

    @Override
    public List<Staff> querySomeStaff(Staff model) {
        return staffDao.querySomeStaff(model);
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public Staff findById(Staff staff) {
        return staffDao.findById(staff.getStaffId());
    }

    @Override
    public Staff saveOrUpdate(Staff staff) {
        //更新
        staffDao.saveOrUpdate(staff);

        //重新查询
        return staffDao.findById(staff.getStaffId());
    }
}
