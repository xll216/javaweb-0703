package com.lanou.crm.education.service.impl;

import com.lanou.crm.education.dao.CourseTypeDao;
import com.lanou.crm.education.domain.CourseType;
import com.lanou.crm.education.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("courseTypeService")
public class CourseTypeServiceImpl implements CourseTypeService {

    @Qualifier("courseTypeDao")
    @Autowired
    private CourseTypeDao courseTypeDao;

    /**
     * 添加一个课程类别
     **/
    @Override
    public CourseType saveOrUpdateCourseType(CourseType model) {
        /*先判断课程的合法性,这个地方也可以用自定义验证进行判断*/
        if (StringUtils.isNotBlank((model.getCourseName())) &&
                StringUtils.isNotBlank(model.getRemark()) &&
                model.getTotal() > 0 &&
                model.getCourseCost() > 0) {

            if (model.getCourseTypeID() > 0) {
                courseTypeDao.update(model);//保存之后将对象返回
            } else {
                courseTypeDao.save(model);
            }
        }

        return model;
    }

    /**
     * 根据id查询某个对象
     **/
    @Override
    public CourseType findById(CourseType courseType) {
        return courseTypeDao.findById(courseType.getCourseTypeID());
    }

    /**
     * 高级查询
     **/
    @Override
    public List<CourseType> findAll(CourseType model) {
        /* 拼凑条件查询语句 */
        StringBuilder sqlWhere = new StringBuilder();
        List<Object> params = new ArrayList<>();

        if (StringUtils.isNotBlank((model.getCourseName()))) {
            sqlWhere.append(" and courseName like ?");
            params.add("%" + model.getCourseName() + "%");
        }

        if (StringUtils.isNotBlank(model.getRemark())) {
            sqlWhere.append(" and remark like ?");
            params.add("%" + model.getRemark() + "%");
        }

        if (StringUtils.isNotBlank(model.getTotalStart())) {
            sqlWhere.append(" and total >= ?");
            params.add(Integer.parseInt(model.getTotalStart()));
        }

        if (StringUtils.isNotBlank(model.getTotalEnd())) {
            sqlWhere.append(" and total <= ?");
            params.add(Integer.parseInt(model.getTotalEnd()));
        }

        if (StringUtils.isNotBlank(model.getLessonCostStart())) {
            sqlWhere.append(" and courseCost >= ?");
            params.add(Double.parseDouble(model.getLessonCostStart()));
        }

        if (StringUtils.isNotBlank(model.getLessonCostEnd())) {
            sqlWhere.append(" and courseCost <= ?");
            params.add(Double.parseDouble(model.getLessonCostEnd()));
        }

        String condition = sqlWhere.toString();
        Object[] paramList = params.toArray();

        return courseTypeDao.findAll(condition, paramList);
    }
}
