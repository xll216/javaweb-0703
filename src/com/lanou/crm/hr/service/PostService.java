package com.lanou.crm.hr.service;

import com.lanou.crm.base.PageBean;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface PostService {
    List<Post> findAll();

    List<Post> findAllByDep(Department department);

    Post findById(Post post);

    Post update(Post post);

    PageBean<Post> findAll(Post model, int pc, int ps);
}
