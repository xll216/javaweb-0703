package com.lanou.crm.education.web.action;

import com.lanou.crm.base.BaseAction;
import com.lanou.crm.education.domain.CourseType;
import com.lanou.crm.education.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller("courseTypeAction")
@Scope("prototype")
public class CourseTypeAction extends BaseAction<CourseType> {
    @Qualifier("courseTypeService")
    @Autowired
    private CourseTypeService courseTypeService;

    /**
     * 添加课程类别
     **/
    public String addOrEditCourse() {
        CourseType courseType = courseTypeService.saveOrUpdateCourseType(getModel());
        System.out.println(courseType);
        return "addOrEditCourse";
    }

    /**
     * 编辑课程
     **/
    public String editCourse() {
        CourseType courseType = courseTypeService.findById(getModel());
        /*将要编辑的对象保存到值栈中*/
        set("courseType", courseType);
        return "editCourse";
    }

    /**
     * 查询所有
     **/
    public String findAll() {
        List<CourseType> courseTypes = courseTypeService.findAll(getModel());
        /*将查询到的集合保存到值栈中*/
        set("courseTypes", courseTypes);
        /*记录一下查询的条件*/
        set("courseType", getModel());
        return "findAll";
    }
}
