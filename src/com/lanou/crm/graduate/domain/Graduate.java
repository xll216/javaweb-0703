package com.lanou.crm.graduate.domain;

import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Graduate {
    private int granduateId;//学生就业 ID
    private String studentId;//学员主键 ID
    private String companyName;//就业公司名称
    private String salary;//薪资
    private String post;//岗位
    private Date entryTime;//入职时间
    private String remark;//备注
    private String classID;//班级主键 ID

    public int getGranduateId() {
        return granduateId;
    }

    public void setGranduateId(int granduateId) {
        this.granduateId = granduateId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "granduateId=" + granduateId +
                ", studentId='" + studentId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary='" + salary + '\'' +
                ", post='" + post + '\'' +
                ", entryTime=" + entryTime +
                ", remark='" + remark + '\'' +
                ", classID='" + classID + '\'' +
                '}';
    }
}
