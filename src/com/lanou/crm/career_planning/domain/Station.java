package com.lanou.crm.career_planning.domain;

import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Station {
    private int stationID;//升级转班主键 ID
    private String studentID;//学员主键 ID
    private String flag;//升级/转班(标识),1 表示升级，2 表 示转班，可以通过选择班级的日期判 断。
    private String staffId;//经办人(登录用户)
    private Date createDate;//操作时间(当前时间)
    private String beforeClassId;//之前的班级 ID
    private String afterClassId;//之后的班级 ID

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBeforeClassId() {
        return beforeClassId;
    }

    public void setBeforeClassId(String beforeClassId) {
        this.beforeClassId = beforeClassId;
    }

    public String getAfterClassId() {
        return afterClassId;
    }

    public void setAfterClassId(String afterClassId) {
        this.afterClassId = afterClassId;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationID='" + stationID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", flag='" + flag + '\'' +
                ", staffId='" + staffId + '\'' +
                ", createDate=" + createDate +
                ", beforeClassId='" + beforeClassId + '\'' +
                ", afterClassId='" + afterClassId + '\'' +
                '}';
    }
}
