package com.lanou.crm.education.service;

import com.lanou.crm.education.domain.CourseType;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface CourseTypeService {
    CourseType saveOrUpdateCourseType(CourseType courseType);

    CourseType findById(CourseType courseType);

    List<CourseType> findAll(CourseType courseType);
}
