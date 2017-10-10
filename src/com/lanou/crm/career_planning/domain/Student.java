package com.lanou.crm.career_planning.domain;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Student {
    private int studentId;//学员主键 ID
    private String name;//姓名(从咨询表中带过来)
    private String telephone;//电话(从咨询表中带过来)
    private String identity;//身份证号
    private String qq;//QQ(从咨询表中带过来)
    private String gender;//性别
    private int mustTuition;//应付学费
    private int actualTuition;//实付学费
    private String email;//Email
    private String school;//毕业学校
    private String education;//学历
    private String professional;//专业
    private String identityAddress;//身份证地址
    private String address;//在京地址
    private String remark;//学员描述
    private String homeTelephone;//家庭联系电话
    private String homeContact;//家庭联系人
    private String status;//状态: 1.新生、2.转班、3.升级、4.退费、5. 毕业
    private String classID;//班级表的外键 classID(一个学生对应 一个班级，一个班级对应多个学生)
    private String referID;//学员咨询 ID(正式学习的学员，与学 生咨询表对应)

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMustTuition() {
        return mustTuition;
    }

    public void setMustTuition(int mustTuition) {
        this.mustTuition = mustTuition;
    }

    public int getActualTuition() {
        return actualTuition;
    }

    public void setActualTuition(int actualTuition) {
        this.actualTuition = actualTuition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getIdentityAddress() {
        return identityAddress;
    }

    public void setIdentityAddress(String identityAddress) {
        this.identityAddress = identityAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getReferID() {
        return referID;
    }

    public void setReferID(String referID) {
        this.referID = referID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", identity='" + identity + '\'' +
                ", qq='" + qq + '\'' +
                ", gender='" + gender + '\'' +
                ", mustTuition=" + mustTuition +
                ", actualTuition=" + actualTuition +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", professional='" + professional + '\'' +
                ", identityAddress='" + identityAddress + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", homeTelephone='" + homeTelephone + '\'' +
                ", homeContact='" + homeContact + '\'' +
                ", status='" + status + '\'' +
                ", classID='" + classID + '\'' +
                ", referID='" + referID + '\'' +
                '}';
    }
}
