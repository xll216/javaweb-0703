package com.lanou.crm.education.domain;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class CourseType {
    private int courseTypeID;//主键 ID
    private double courseCost;//课程费用
    private int total;//总课时
    private String courseName;//课程类别名称
    private String remark;//课程介绍模板

    /*高级查询*/
    private String totalStart;//总学时开始
    private String totalEnd;//总学时结束
    private String lessonCostStart;//课程费用开始
    private String lessonCostEnd;//课程费用结束

    public int getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(int courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }

    public String getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    public String getLessonCostStart() {
        return lessonCostStart;
    }

    public void setLessonCostStart(String lessonCostStart) {
        this.lessonCostStart = lessonCostStart;
    }

    public String getLessonCostEnd() {
        return lessonCostEnd;
    }

    public void setLessonCostEnd(String lessonCostEnd) {
        this.lessonCostEnd = lessonCostEnd;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeID=" + courseTypeID +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                ", totalStart=" + totalStart +
                ", totalEnd=" + totalEnd +
                ", lessonCostStart=" + lessonCostStart +
                ", lessonCostEnd=" + lessonCostEnd +
                '}';
    }
}
