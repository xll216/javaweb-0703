package com.lanou.crm.career_planning.domain;

import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Runoff {
    private int runOffId;//流失主键 ID
    private String studentId;//学员主键 ID
    private String staffId;//业务人员，经办人
    private Date createDate;//流失时间
    private String isRefund;//是否退款
    private String refundAmount;//退款金额
    private String remark;//描述(流失原因)

    public int getRunOffId() {
        return runOffId;
    }

    public void setRunOffId(int runOffId) {
        this.runOffId = runOffId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Runoff{" +
                "runOffId=" + runOffId +
                ", studentId='" + studentId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", createDate=" + createDate +
                ", isRefund='" + isRefund + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
