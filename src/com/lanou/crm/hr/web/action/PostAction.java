package com.lanou.crm.hr.web.action;

import com.lanou.crm.base.BaseAction;
import com.lanou.crm.base.PageBean;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post> {

    private List<Post> posts;

    public String findAllWithDepartment() throws IOException {
        // 1. 查询
        posts = this.getPostService().findAllByDep(
                this.getModel().getDepartment());
        return SUCCESS;
    }

    public String findAll() {
        // 查询职务

        // 给定 pageNum, pageSize
        /** 1.得到pc  2.设置 ps*/
        int pc = this.getPageNum(); //得到pc
        int ps = 3;

        PageBean<Post> pb = this.getPostService().findAll(getModel(), pc, ps);
//        System.out.println(pb);

        this.put("pb", pb);

        return "findAll";
    }

    /**
     * 将修改的职务对象更新到数据库中
     **/
    public String update() {
        Post post = getModel();
        System.out.println("保存前：" + post);

        Department department = getDepartmentService().findById(post.getDepartment());
        post.setDepartment(department);

        post = getPostService().update(post);

        System.out.println("保存后：" + post);

        return "update";
    }

    /**
     * 进入编辑界面
     **/
    public String addOrEditPost() {
        /*获得所有部门*/
        List<Department> allDepartment = getDepartmentService().findAllDepartment();

        /*查找当前要编辑的职务对象*/
        Post post = getPostService().findById(getModel());

        ActionContext.getContext().put("departments", allDepartment);
        if (post != null) {
            ActionContext.getContext().put("post", post);
        }
        return "addOrEditPost";
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
