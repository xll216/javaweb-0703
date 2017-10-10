package com.lanou.crm.hr.web.action;

import com.lanou.crm.base.BaseAction;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;
import com.lanou.crm.hr.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    /**
     * 跳转到添加员工界面
     **/
    public String addStaff() {
        List<Department> allDepartment = this.getDepartmentService().findAllDepartment();
        ActionContext.getContext().put("departments", allDepartment);
        return "addStaff";
    }


    /**
     * 编辑员工后的保存处理
     **/
    public String edit() {
        Staff staff = getModel();
        System.out.println("原对象：" + staff);

        Post post = getPostService().findById(staff.getPost());

        staff.setPost(post);

        staff = getStaffService().saveOrUpdate(staff);

        System.out.println("更新后对象：" + staff);
        return "edit";
    }

    /**
     * 跳转进入编辑员工界面，需要先获取一下数据
     **/
    public String editStaff() {
        //1 查询所有部门
        List<Department> allDepartment = this.getDepartmentService().findAllDepartment();

        /*去服务中查找某个用户*/
        Staff staff = getStaffService().findById(getModel());

        //2 查询所有职务, 高级查询不是必须要选择部门才能有职位
        List<Post> allPost = this.getPostService().findAllByDep(staff.getPost().getDepartment());

        ActionContext.getContext().put("departments", allDepartment);
        ActionContext.getContext().put("allPost", allPost);
        ActionContext.getContext().put("staff", staff);

        return "editStaff";
    }

    /**
     * 获取员工列表
     **/
    public String listStaff() {
        return SUCCESS;
    }

    /**
     * 注册员工
     **/
    public String register() {
        return SUCCESS;
    }

    /**
     * 修改员工密码
     **/
    public String updPwd() {
        return "updPwd";
    }


    /**
     * 查询所有员工
     * + 高级查询
     *
     * @return
     */
    public String findAll() {

        //1 查询所有部门
        List<Department> allDepartment = this.getDepartmentService().findAllDepartment();
//        for (Department de : allDepartment) {
//            for (Post post : de.getPostSet()) {
//                System.out.println(post);
//            }
//        }
//        System.out.println("************");

        //2 查询所有职务, 高级查询不是必须要选择部门才能有职位
        List<Post> allPost = this.getPostService().findAll();

//        for (Post post : allPost) {
//            System.out.println(post.getDepartment().getDepName());
//            for (Staff staff : post.getStaffSet()) {
//                System.out.println(staff);
//            }
//        }
//        System.out.println("************");

        // 查询所有员工
        List<Staff> staffList = this.getStaffService().querySomeStaff(getModel());
//        System.out.println("所有员工:  " + staffList);

        ActionContext.getContext().put("departments", allDepartment);
        ActionContext.getContext().put("allPost", allPost);
        ActionContext.getContext().put("staffList", staffList);
        return "findAll";
    }

    /**
     * 注销重新登陆
     *
     * @return
     */
    public String logout() {
        this.getSession().invalidate();
        return "login";
    }


    /**
     * 登录
     **/
    public String login() {
        if (getStaffService().login(getModel().getLoginName(), getModel().getLoginPwd()) != null) {
            sessionPut("loginUser", getModel());
            sessionPut("loginName", getModel().getLoginName());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
