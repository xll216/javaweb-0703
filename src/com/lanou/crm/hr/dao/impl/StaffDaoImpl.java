package com.lanou.crm.hr.dao.impl;

import com.lanou.crm.base.impl.BaseDaoImpl;
import com.lanou.crm.hr.dao.StaffDao;
import com.lanou.crm.hr.domain.Staff;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {

    @Override
    public Staff find(String loginName, String loginPwd) {
        String hql = "FROM Staff where loginName=? and loginPwd=?";
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find(hql, new String[]{loginName, loginPwd});
        if (staffList.size() > 0) {
            return staffList.get(0);
        } else
            return null;
    }


    /**
     * 查找同一个职务的员工集合
     **/
    @Override
    public List<Staff> querySomeStaff(Staff model) {
        String staffName = model.getStaffName();
        int postId = model.getPost() != null ? model.getPost().getPostId() : -1;
        int depId = model.getPost() != null && model.getPost().getDepartment() != null ?
                model.getPost().getDepartment().getDepID() : -1;
        List<Staff> staffList = null;

        String hql = "FROM Staff where 1=1 ";
        Object[] params = new Object[3];
        int index = -1;
        if (!StringUtils.isEmpty(staffName)) {
            hql += "and staffName = ? ";
            index++;
            params[index] = staffName;/*按名字查找*/
        }

        if (postId != -1) {
            hql += "and post.postId = ? ";
            index++;
            params[index] = postId;/*按职务查找*/
        }

        if (depId != -1) {
            hql += "and post.department.depID = ?";
            index++;
            params[index] = depId;/*按部门查找*/
        }
        /*合并查询条件*/
        if (index != -1) {
            Object[] parameters = new Object[index + 1];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = params[i];
            }
            staffList = (List<Staff>) getHibernateTemplate().find(hql, parameters);
        } else staffList = findAll();

        return staffList;
    }
}
