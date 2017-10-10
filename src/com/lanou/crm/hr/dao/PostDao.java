package com.lanou.crm.hr.dao;

import com.lanou.crm.base.BaseDao;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface PostDao extends BaseDao<Post> {
    List<Post> findAllByDep(Department department);
}
