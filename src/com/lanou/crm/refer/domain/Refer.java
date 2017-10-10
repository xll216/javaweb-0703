package com.lanou.crm.refer.domain;

import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Refer {
    private int referId;//主键 ID
    private String name;//姓名
    private String telephone;//电话
    private String qq;//QQ(手动填写)
    private Date createDate;//建档日期，新增时系统时间，编辑时不能编辑
    private String intentionLevel;//意向级别
    private String courseTypeId;//意向学科
    private String classId;//意向班级
    private String source;//来源
    private String status;//状态(1.咨询中、2.已报名)
    private String remark;//备注(手动填写)
    private String staffId;//营销人员(从 Session 中获取)，当前 登录人的 ID


    public int getReferId() {
        return referId;
    }

    public void setReferId(int referId) {
        this.referId = referId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Refer{" +
                "referId=" + referId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", createDate=" + createDate +
                ", intentionLevel='" + intentionLevel + '\'' +
                ", courseTypeId='" + courseTypeId + '\'' +
                ", classId='" + classId + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", staffId='" + staffId + '\'' +
                '}';
    }
}
