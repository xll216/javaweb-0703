package com.lanou.crm.hr.service.impl;

import com.lanou.crm.base.PageBean;
import com.lanou.crm.hr.dao.PostDao;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;
import com.lanou.crm.hr.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Qualifier("postDao")
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    /**
     * 查找某一部门的职位集合
     **/
    @Override
    public List<Post> findAllByDep(Department department) {
        return postDao.findAllByDep(department);
    }

    @Override
    public Post findById(Post post) {
        return postDao.findById(post.getPostId());
    }

    @Override
    public Post update(Post post) {
        /*更新当前职务对象*/
        if (post.getPostId() > 0) {
            postDao.update(post);
        } else {
            postDao.save(post);
        }
        return post;//重新获取职务对象
    }

    @Override
    public PageBean<Post> findAll(Post model, int pc, int ps) {
        int totalRecoder = postDao.getTotalRecord();

        PageBean<Post> pb = new PageBean<>(pc, ps, totalRecoder);
        List<Post> posts = postDao.findAllByPage("", null, pb);
        pb.setBeanList(posts);
        return pb;
    }

}
