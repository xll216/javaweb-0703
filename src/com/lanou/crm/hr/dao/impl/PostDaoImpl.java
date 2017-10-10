package com.lanou.crm.hr.dao.impl;

import com.lanou.crm.base.impl.BaseDaoImpl;
import com.lanou.crm.hr.dao.PostDao;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    /**
     * 查找某一个部门的所有职位
     **/
    @Override
    public List<Post> findAllByDep(Department department) {
        String hql = "FROM Post where department = ?";
        List<Post> postList = (List<Post>) getHibernateTemplate().find(hql, new Object[]{department});
        return postList;
    }
}
